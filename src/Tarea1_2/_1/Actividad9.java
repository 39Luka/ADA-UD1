package Tarea1_2._1;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class Actividad9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Introduce un teléfono: ");
        String telefono = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        String linea = sb.append(nombre).append("-").append(telefono).toString();


        try(PrintWriter pw = new PrintWriter(new FileWriter("agenda.txt", true))) {

            pw.println(linea);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
