package Tarea1_2._1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Actividad11 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("Resumen").append(System.lineSeparator());

        String notas,agenda;
        try {
             notas = Files.readString(Path.of("nota.txt"));
             agenda = Files.readString(Path.of("agenda.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sb.append(notas).append(System.lineSeparator())
                .append(agenda).append(System.lineSeparator());


        try {
            Files.writeString(Path.of("resumen.txt"), sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
