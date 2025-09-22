package Tarea1_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Actividad2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un ruta: ");
        String nombreRuta = sc.nextLine();

        Path path = Path.of(nombreRuta);
        Map<String, Integer> mapa = new HashMap<>();

        try (Stream<Path> stream = Files.walk(path)){

            stream
                    .filter(Files::isRegularFile)
                    .map(path1 -> {
                        String nombreFile = path1.getFileName().toString();

                        int indice = nombreFile.lastIndexOf(".");

                        String ext;
                        if (indice == -1) ext = "sin_ext";
                            else ext = nombreFile.substring(indice);

                        return ext;
                    })
                    .forEach(ext -> mapa.put(ext, mapa.getOrDefault(ext, 0)+1));

            Stream<Map.Entry<String,Integer>> stream1 = mapa.entrySet().stream();
            stream1
                    .forEach(s ->{
                        System.out.println(s.getKey() +": "+s.getValue());
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
