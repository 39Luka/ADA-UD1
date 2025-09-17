package Tarea1_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Actividad4 {
    public static void main(String[] args) {

        Path base = Path.of("proyecto");


        List<Path> carpetas = List.of(
                base,
                base.resolve("src"),
                base.resolve("docs"),
                base.resolve("resources")
        );

        for (Path carpeta : carpetas)
            if (!Files.exists(carpeta)) {
                try {
                    Files.createDirectories(carpeta);
                    System.out.println("Se ha creado la carpeta: " + carpeta);
                } catch (IOException e) {
                    System.err.println("Error al crear la carpeta: " + carpeta);
                }

            }
            else System.out.println("Ya existe la carpeta: " + carpeta);




    }
}
