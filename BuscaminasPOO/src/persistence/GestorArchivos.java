package persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Juego;

public class GestorArchivos {

    public static void guardar(
            Juego juego,
            String archivo)
            throws IOException {

        ObjectOutputStream salida =
                new ObjectOutputStream(
                        new FileOutputStream(
                                archivo));

        salida.writeObject(juego);

        salida.close();
    }

    public static Juego cargar(
            String archivo)
            throws IOException,
            ClassNotFoundException {

        ObjectInputStream entrada =
                new ObjectInputStream(
                        new FileInputStream(
                                archivo));

        Juego juego =
                (Juego) entrada.readObject();

        entrada.close();

        return juego;
    }

}
