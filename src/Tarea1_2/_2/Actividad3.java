package Tarea1_2._2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Actividad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] filtrar = {"INFO", "WARN", "ERROR"};

        System.out.println(""" 
                Niveles a filtrar:
                0.INFO
                1.WARN
                2.ERROR
                """);
        int opc = sc.nextInt();

        if (opc >= 0 && opc <= 2){
            try (BufferedReader br = new BufferedReader(new FileReader("server.log"))){
                String line;
                while ((line = br.readLine())!= null){
                    if(line.contains(filtrar[opc]))
                        System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        sc.close();

    }
}
