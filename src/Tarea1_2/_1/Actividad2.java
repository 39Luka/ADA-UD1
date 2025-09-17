package Tarea1_2._1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Actividad2 {
    public static void main(String[] args) {

        try(FileInputStream fis = new FileInputStream("salida.bin")) {

            int currentByte;
            while ((currentByte = fis.read()) != -1){
                System.out.println(currentByte);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado");
        } catch (IOException e) {
            System.err.println("Error de acceso al fichero");
        }
    }
}

