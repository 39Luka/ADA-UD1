package Tarea1_2._1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Actividad8 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("nota.txt"))) {
            String lineaLeida;
            int numLineas = 0;

            while ((lineaLeida = br.readLine()) != null)
            {
                numLineas++;
                System.out.println("Nota "+numLineas+": "+lineaLeida);
            }
            System.out.println("Total Lineas: "+ numLineas);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
