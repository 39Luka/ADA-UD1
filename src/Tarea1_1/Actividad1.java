package Tarea1_1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



public class Actividad1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una ruta:");

        String nombrePath = sc.nextLine();

        Path origen = Paths.get(nombrePath);

        if(Files.exists(origen) && Files.isDirectory(origen)) {

            try {
                DirectoryStream<Path> paths = Files.newDirectoryStream(origen);

                paths.forEach(path-> {

                    if (Files.isDirectory(path))
                        System.out.println("Directorio" + path);

                    else if (Files.isRegularFile(path))
                        System.out.println("Fichero" + path);

                });


            } catch (IOException e) {

                System.err.println(e.getMessage());
            }

        }
    }
}