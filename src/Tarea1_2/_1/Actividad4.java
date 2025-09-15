package Tarea1_2._1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Actividad4 {
    public static void main(String[] args) {

        long start, end; //Timers
        byte[] content = new byte[1000000];
        Random random = new Random(42);
        random.nextBytes(content);

        try(FileOutputStream fos = new FileOutputStream("salida.bin");
        ) {

            start = System.nanoTime();
            fos.write(content);
            end = System.nanoTime();
            System.out.println("FileOutputStream: " + (end-start));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(FileOutputStream fos = new FileOutputStream("salida.bin");
            BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {

            start = System.nanoTime();
            bos.write(content);
            end = System.nanoTime();
            System.out.println("BufferedOutputStream: " + (end-start));


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            start = System.nanoTime();
            Files.write(Path.of("salida.bin"),content);
            end = System.nanoTime();
            System.out.println("Files.write: " + (end-start));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       /* FileOutputStream: 974556
        BufferedOutputStream: 657582
        Files.write: 4313693

        BufferedOutputStream es la forma más rápida de leer la información, mientras que la forma de java nio es la más lenta.
        */
    }
}
