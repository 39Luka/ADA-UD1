package Tarea1_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Actividad5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta base: ");
        String ruta = sc.nextLine();

        Path path = Path.of(ruta);
        try(Stream<Path> stream = Files.walk(path)) {
            stream
                    .sorted(Comparator.reverseOrder())
                    .filter(Files::isDirectory)
                    .filter(p -> !p.equals(path))
                    .forEach(p -> {
                        try(Stream<Path> contenido =  Files.list(p)){
                            boolean vacio = contenido.findAny().isEmpty();
                            if(vacio) Files.delete(p);
                            System.out.println("Se ha borrado: " + p);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
