package Tarea1_2._1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Actividad12 {
    public static void main(String[] args) {


        Path file1 = Path.of("1.txt");
        Path file2 = Path.of("2.txt");
        Path mixed = Path.of("fusion.txt");

        try {
            Files.newBufferedReader(file1, StandardCharsets.UTF_8);
            Files.newBufferedReader(file2, StandardCharsets.UTF_8);
            Files.newBufferedWriter(mixed,StandardCharsets.UTF_8, StandardOpenOption.APPEND);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
