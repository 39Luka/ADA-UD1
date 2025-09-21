package Tarea1_2._2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Actividad2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la palabra clave: ");
        String palabra = sc.nextLine();

        Pattern pattern = Pattern.compile(palabra, Pattern.CASE_INSENSITIVE);

        System.out.println("Introduce la ruta: ");
        String ruta = sc.nextLine();

        Path origen = Path.of(ruta);

        AtomicInteger total = new AtomicInteger();

        if (Files.exists(origen) && Files.isRegularFile(origen)) {
            try (Stream<String> contenido = Files.lines(origen);
            ) {
                contenido.forEach(linea -> {
                    Matcher matcher = pattern.matcher(linea);
                    while (matcher.find()) {
                        total.getAndIncrement();
                    }
                });

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(total.get());
        sc.close();
    }

}
