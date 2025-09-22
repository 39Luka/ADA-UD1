package Tarea1_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Actividad3 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el tamaño a superar(MB): ");


        int size = sc.nextInt();

        try (Stream<Path> stream = Files.find(Path.of("."),Integer.MAX_VALUE,
                (path, basicFileAttributes) -> basicFileAttributes.size() > size * 1024L * 1024L)){

            stream.
                    sorted((e1, e2) -> {
                        try {
                            return Long.compare(Files.size(e2), Files.size(e1));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .forEach(path -> {
                        try {
                            long bytes = Files.size(path);
                            double mb = bytes / (1024.0 * 1024.0);
                            System.out.printf("%s -> %.2f MB%n", path, mb);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
