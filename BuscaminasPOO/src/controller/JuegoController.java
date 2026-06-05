package controller;

import exceptions.CasillaMarcadaException;
import exceptions.CasillaYaDescubiertaException;
import exceptions.CoordenadaInvalidaException;

import model.Coordenada;
import model.Juego;

import util.CoordenadaUtils;

import view.Menu;
import view.VistaConsola;
import view.InicioJuego;
import persistence.GestorArchivos;

public class JuegoController {

    private Juego juego;
    private VistaConsola vista;

    public JuegoController() {

        vista = new VistaConsola();

        InicioJuego.mostrar();

        int opcion =
                vista.leerOpcion();

        try {

            switch (opcion) {

                case 1:

                    String nombre =
                            vista.leerTexto(
                                    "Ingrese nombre: ");

                    juego =
                            new Juego(nombre);

                    break;

                case 2:

                    juego =
                            GestorArchivos.cargar(
                                    "partida.dat");

                    break;

                case 3:

                    System.exit(0);

                    break;

                default:

                    String nombre2 =
                            vista.leerTexto(
                                    "Ingrese nombre: ");

                    juego =
                            new Juego(nombre2);
            }

        } catch (Exception e) {

            vista.mostrarMensaje(
                    "No se pudo cargar la partida.");

            String nombre =
                    vista.leerTexto(
                            "Ingrese nombre: ");

            juego =
                    new Juego(nombre);
        }
    }

    public void iniciar() {

        while (!juego.isTerminado()) {

            vista.mostrarTablero(
                    juego.getTablero());

            Menu.mostrar();

            int opcion =
                    vista.leerOpcion();

            procesarOpcion(opcion);
        }

        finalizarJuego();
    }

    private void procesarOpcion(
            int opcion) {

        try {

        	switch (opcion) {

            case 1:

                descubrirCasilla();
                break;

            case 2:

                marcarCasilla();
                break;

            case 3:

                guardarPartida();
                break;

            case 4:

                cargarPartida();
                break;

            case 5:

                System.exit(0);
                break;

            default:

                vista.mostrarMensaje(
                        "Opción inválida");
        }

        } catch (Exception e) {

            vista.mostrarMensaje(
                    e.getMessage());
        }
    }

    private void descubrirCasilla()
            throws CasillaYaDescubiertaException,
            CasillaMarcadaException,
            CoordenadaInvalidaException {

        String texto =
                vista.leerTexto(
                        "Ingrese coordenada (A5): ");

        Coordenada coordenada =
                CoordenadaUtils.convertir(
                        texto);

        boolean vivo =
                juego.descubrir(
                        coordenada.getFila(),
                        coordenada.getColumna());

        if (!vivo) {

            vista.mostrarMensaje(
                    "BOOM! Has perdido.");
        }
    }

    private void marcarCasilla()
            throws CoordenadaInvalidaException {

        String texto =
                vista.leerTexto(
                        "Ingrese coordenada: ");

        Coordenada coordenada =
                CoordenadaUtils.convertir(
                        texto);

        juego.marcar(
                coordenada.getFila(),
                coordenada.getColumna());

        vista.mostrarMensaje(
                "Casilla marcada.");
    }

    private void guardarPartida() {

        try {

            GestorArchivos.guardar(
                    juego,
                    "partida.dat");

            vista.mostrarMensaje(
                    "Partida guardada correctamente.");

        } catch (Exception e) {

            vista.mostrarMensaje(
                    "Error al guardar: "
                            + e.getMessage());
        }
    }
    
    private void cargarPartida() {

        try {

            juego =
                    GestorArchivos.cargar(
                            "partida.dat");

            vista.mostrarMensaje(
                    "Partida cargada correctamente.");

        } catch (Exception e) {

            vista.mostrarMensaje(
                    "Error al cargar: "
                            + e.getMessage());
        }
    }
    
    private void finalizarJuego() {

        vista.mostrarTablero(
                juego.getTablero());

        if (juego.isVictoria()) {

            vista.mostrarMensaje(
                    "FELICIDADES, GANASTE!");
        } else {

            vista.mostrarMensaje(
                    "FIN DEL JUEGO");
        }
    }

}