package Tarea1_1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Actividad5 {
    public static void main(String[] args) {

        Path origen = Path.of("entrada");
        Path txt = Path.of("textos");
        Path jpg = Path.of("imagenes");

        try {
            Files.createDirectories(origen);
            Files.createDirectories(txt);
            Files.createDirectories(jpg);

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(origen)) {

                for (Path archivo : stream) {
                    if (Files.isRegularFile(archivo)){
                        String nombre = archivo.getFileName().toString();
                        if (nombre.endsWith(".txt")){
                            Files.move(archivo,txt.resolve(nombre));
                        } else if (nombre.endsWith(".jpg")) {
                            Files.move(archivo,jpg.resolve(nombre));

                        }
                    }
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
