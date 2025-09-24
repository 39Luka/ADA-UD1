package Tarea1_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Actividad4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una ruta: ");
        String ruta = sc.nextLine();

        System.out.println("Introduce un prefijo: ");
        String prefijo = sc.nextLine();

        System.out.println("Introduce una extensión: ");
        String extension = sc.nextLine();

        Path path = Path.of(ruta);

        String regex = "^" + prefijo + ".*\\." + extension + "$";
        Pattern pattern = Pattern.compile(regex);

        try (Stream<Path> paths = Files.walk(path)){
            paths
                    .filter(p-> pattern.matcher(p.getFileName().toString()).matches())
                    .forEach(p -> {
                        try {
                           long sizeKB = Files.size(p) / 1024;
                           System.out.println(p + "-" + sizeKB);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
