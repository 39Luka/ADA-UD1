package Tarea1_2._1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Actividad7 {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("nota.txt")) {

            int caracterLeido;

            while((caracterLeido = fr.read() ) != -1)
                System.out.println((char)caracterLeido);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
