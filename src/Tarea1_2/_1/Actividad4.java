package Tarea1_2._1;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Actividad4 {
    public static void main(String[] args) {

        byte[] content = new byte[1000000];

        try(FileOutputStream fos = new FileOutputStream("salida.bin")) {

            fos.write(content);
            System.out.println(System.nanoTime());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedOutputStream bos = new BufferedOutputStream()
        }

    }
}
