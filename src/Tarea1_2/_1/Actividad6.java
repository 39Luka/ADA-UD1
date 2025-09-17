package Tarea1_2._1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una frase: ");
        String frase = sc.nextLine();

        try (FileWriter fw = new FileWriter("nota.txt", true);){
            fw.write(frase + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
