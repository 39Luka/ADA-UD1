package Tarea1_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.DAYS;

public class Actividad6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número de días: ");
        int numDias = sc.nextInt();
        long milisegundos = DAYS.toMillis(numDias);
        long fechaDeHoy = System.currentTimeMillis();

        try (Stream<Path> stream = Files.find(Path.of("."), Integer.MAX_VALUE,
                (path, basicFileAttributes) -> basicFileAttributes.lastModifiedTime().toMillis() >= (fechaDeHoy - milisegundos))){

            stream
                    .sorted(Comparator.comparingLong(p -> {
                        try {
                            return Files.getLastModifiedTime((Path) p).toMillis();
                        } catch (IOException e) {
                            return 0L;
                        }
                    }).reversed())
                    .forEach(p -> {
                        try {
                            long millis = Files.getLastModifiedTime(p).toMillis();
                            System.out.println(p.toAbsolutePath() + " - modificado: " + new Date(millis));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}