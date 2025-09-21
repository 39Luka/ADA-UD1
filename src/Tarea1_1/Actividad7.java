package Tarea1_1;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Actividad7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una ruta: ");
        String nombreRuta = sc.nextLine();

        Path ruta = Path.of(nombreRuta);

        if (Files.exists(ruta) && Files.isDirectory(ruta)){
            try {
                DirectoryStream<Path> stream = Files.newDirectoryStream(ruta);
                for (Path path : stream){
                    String nombre = path.getFileName().toString();
                    if (nombre.endsWith(".java")){
                        System.out.println(nombre +" "+ Files.size(path));
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
