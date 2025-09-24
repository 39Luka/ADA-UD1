package Tarea1_3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.DAYS;

public class Actividad6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número de días: ");
        int numDias = sc.nextInt();

        try(Stream<Path> stream = Files.find(Path.of("."),Integer.MAX_VALUE,
                (path, basicFileAttributes) -> basicFileAttributes.lastModifiedTime() <= 5 )

    }
}
