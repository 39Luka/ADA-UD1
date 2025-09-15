package Tarea1_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Unidad 1 Tarea 1 Actividad 3
 * @author Silvia Cachón Leiva
 */
public class Actividad3 {
    public static void main(String[] args) {

            List<Path> paths = List.of(Path.of("pruebas/1.txt"), Path.of("pruebas/2.txt"));

            paths.stream().forEach(path ->{

                if(!Files.exists(path)){
                    try {
                        Files.createDirectories(path);
                    } catch (IOException e) {
                        System.err.println("No se ha podido crear el fichero: " + path);
                    }
                }
            });

            Path backup = Path.of(("respaldo"));

            if(!Files.isDirectory(backup)) {
                try {
                    Files.createDirectory(backup);
                } catch (IOException e) {
                    System.err.println("No se ha podido crear el directorio: respaldo");
                }
            }


            for (Path path : paths) {
                try {
                    Files.copy(path, backup.resolve(path.getFileName()));
                } catch (IOException e) {
                    System.err.println("No se ha copiado el fichero: " + path);                }
            }












    }
}
