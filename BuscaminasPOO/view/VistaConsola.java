package view;

import java.util.Scanner;

import model.CasillaBase;
import model.CasillaNormal;
import model.Tablero;

public class VistaConsola {

    private Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    public String leerTexto(String mensaje) {

        System.out.print(mensaje);

        return scanner.nextLine();
    }

    public int leerOpcion() {

        System.out.print("Seleccione una opción: ");

        return Integer.parseInt(
                scanner.nextLine());
    }

    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }

    public void mostrarTablero(Tablero tablero) {

        System.out.println();

        System.out.print("    ");

        for (int i = 1; i <= 10; i++) {

            System.out.printf("%2d ", i);
        }

        System.out.println();

        for (int fila = 0;
             fila < tablero.getTamano();
             fila++) {

            System.out.print(
                    (char) ('A' + fila) + " | ");

            for (int columna = 0;
                 columna < tablero.getTamano();
                 columna++) {

                CasillaBase casilla =
                        tablero.getCasilla(
                                fila,
                                columna);

                System.out.print(
                        obtenerSimbolo(casilla)
                                + "  ");
            }

            System.out.println();
        }

        System.out.println();
    }

    private String obtenerSimbolo(
            CasillaBase casilla) {

        if (casilla.isMarcada()) {

            return "⚑";
        }

        if (!casilla.isDescubierta()) {

            return "■";
        }

        if (casilla.tieneMina()) {

            return "*";
        }

        CasillaNormal normal =
                (CasillaNormal) casilla;

        return String.valueOf(
                normal.getMinasAlrededor());
    }

}
