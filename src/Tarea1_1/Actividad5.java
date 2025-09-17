package Tarea1_1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Actividad5 {
    public static void main(String[] args) {

        Path origen = Path.of("entrada");

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(origen)) {

            for (Path path : stream){

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
