package Tarea1_3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Actividad1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un ruta: ");
        String nombreRuta = sc.nextLine();

        Path path = Path.of(nombreRuta);

        try (Stream<Path> stream = Files.walk(path,2)){
            stream
                    .forEach(path1 ->
                    {
                        if (Files.isDirectory(path1)) {
                            System.out.println("Directorio: " + path1);

                        } else if (Files.isRegularFile(path1)) {
                            System.out.println("Fichero: " + path1);

                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
