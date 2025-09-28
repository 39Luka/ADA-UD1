package Tarea1_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Actividad8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una ruta: ");
        String ruta = sc.nextLine();
        Path path = Path.of(ruta);
        if (Files.exists(path)){
            Map<String, Integer> map = new HashMap<>();
            try(Stream<Path> stream = Files.walk(path)){
                stream
                        .filter(Files::isRegularFile)
                        .forEach(p ->{
                            String nombre = p.getFileName().toString();
                            map.put(nombre, map.getOrDefault(nombre,0)+1);
                        });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stream<Map.Entry<String,Integer>> stream1 = map.entrySet().stream();
            AtomicInteger numRepetidos = new AtomicInteger();
            StringBuilder sb = new StringBuilder();
            stream1.forEach(e -> {
                if(e.getValue() > 1 ){
                    numRepetidos.getAndIncrement();
                    sb.append("- ").append(e.getKey()).append(": ").append(e.getValue()).append(" ocurrencias").append("\n");
                }
            } );
            System.out.println("Duplicados (criterio:mismo nombre): "+ numRepetidos+ " ficheros");
            System.out.println(sb);
        }
    }
}
