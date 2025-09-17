package Tarea1_2._1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;


public class Actividad1 {


    public static void main(String[] args) {

        byte[] bytes = {65,66,67};

        try(FileOutputStream fos = new FileOutputStream("salida.bin")){

            fos.write(bytes);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {

            Files.write(Path.of("salida.bin"), bytes, StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // FileOutStream sobreescribe por defecto, NO añade una nueva línea.
    // Files.write con APPEND SI añade, por lo que si se ejecuta 2 veces aparece la línea 2 veces.

}
