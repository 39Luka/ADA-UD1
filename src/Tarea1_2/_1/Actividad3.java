package Tarea1_2._1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Unidad 1 Tarea 2.1 Actividad 3
 * @author Silvia Cachón Leiva
 */
public class Actividad3 {
    public static void main(String[] args) {
        try{
            Path origin = Path.of("salida.bin");
            Path destiny = Path.of("copia.bin");

            byte[] content = Files.readAllBytes(origin);
            Files.write(destiny, content);

            byte[] destinyContent = Files.readAllBytes(destiny);
            System.out.println("Tamaño: "+ destinyContent.length);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
