package Tarea1_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class Actividad7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una ruta: ");
        String ruta = sc.nextLine();
        Path path = Path.of(ruta);

        if (Files.exists(path)){
            AtomicLong size = new AtomicLong();
            AtomicInteger numFicheros = new AtomicInteger();
            AtomicInteger numDirectorios = new AtomicInteger();
            try(Stream<Path> stream = Files.walk(path)){
                stream.forEach(p -> {
                    if (Files.isRegularFile(p)){
                        try {
                            size.addAndGet(Files.size(p));
                            numFicheros.getAndIncrement();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (Files.isDirectory(p)) {
                        numDirectorios.getAndIncrement();
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            double tamañoKB = size.get() / 1024.0;
            double tamañoMB = size.get() / (1024.0*1024.0);
            System.out.println("Base: " + path.toAbsolutePath());
            System.out.printf("Tamaño total: %.2f MB, %.2f KB%n", tamañoMB,tamañoKB);
            System.out.println("Ficheros: " + numFicheros);
            System.out.println("Directorios (Con la base): " + numDirectorios);

        }




    }
}
