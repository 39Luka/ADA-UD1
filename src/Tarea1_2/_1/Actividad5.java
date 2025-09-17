package Tarea1_2._1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Actividad5 {
    public static void main(String[] args) {

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("imagen.png"));){

            byte [] png = {-119,80,78,71,13,10,26,10};
            int byteLeido;
            boolean isPng = true;

            for (int i = 0; i < 8; i++) {
                byteLeido = bis.read();
                if (png[i] != (byte) byteLeido) isPng = false;
            }

            if(isPng) System.out.println("PNG Válido");
                    else System.out.println("NO es PNG");;

        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado");
        } catch (IOException e) {
            System.err.println("Error de entrada salida");
        }
    }
}
