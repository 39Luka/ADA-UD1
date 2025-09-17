package Tarea1_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;



public class Actividad2 {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

        System.out.println("Introduce el nombre del fichero: ");

        String fileName = sc.nextLine();

        Path path = Path.of(fileName);

        if (Files.exists(path) && Files.isRegularFile(path)) {

            System.out.println("¿Desea borrar el fichero: " + fileName + "?");
            System.out.println("""
                    1.SI
                    2.NO
                    """);
            int confirm = sc.nextInt();

            if (confirm == 1) {

                try {
                    Files.deleteIfExists(path);
                    System.out.println("Se ha eliminado el fichero");

                } catch (IOException e) {
                    System.err.println("No se ha podido eliminar el fichero");
                }

            }

        }

    }
}