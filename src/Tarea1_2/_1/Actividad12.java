package Tarea1_2._1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

        try (BufferedReader brFile1 = Files.newBufferedReader(file1, StandardCharsets.UTF_8);
             BufferedReader brFile2 = Files.newBufferedReader(file2, StandardCharsets.UTF_8);
             BufferedWriter bw = Files.newBufferedWriter(mixed,StandardCharsets.UTF_8, StandardOpenOption.CREATE);){

            String lineaFile1;
            String lineaFile2 = null;
            int numLineasFile1 = 0;
            int numLineasFile2 = 0;

            while ((lineaFile1 = brFile1.readLine())!= null ||
                    (lineaFile2 = brFile2.readLine()) != null){

                if(lineaFile1 != null){
                    bw.write(lineaFile1 + System.lineSeparator());
                    numLineasFile1++;
                }
                if(lineaFile2 != null) {
                    bw.write(lineaFile2 + System.lineSeparator());
                    numLineasFile2++;
                }

            }
            System.out.println("Lineas file1: " + numLineasFile1);
            System.out.println("Lineas file2: " +numLineasFile2);
            System.out.println("Total lineas: " +(numLineasFile1+numLineasFile2));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
