package Tarea1_2._1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Actividad10 {
    public static void main(String[] args) {
        Path origen = Path.of("agenda.txt");

        try{
            String contenido = Files.readString(origen);

            System.out.println(contenido);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
