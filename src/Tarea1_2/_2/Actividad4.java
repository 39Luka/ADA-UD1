package Tarea1_2._2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Actividad4 {
    public static void main(String[] args) {

        Path origen = Path.of("documento.txt");
        HashMap<String, Integer> top = new HashMap<>();

        try (Stream<String> lineas = Files.lines(origen)) {

            List<String> palabras = lineas
                    .flatMap(linea -> Arrays.stream(
                            linea.replaceAll("\\p{Punct}", "")
                                    .split("\\s+")))
                    .filter(palabra -> palabra.length() > 5)
                    .toList();


            palabras.forEach(palabra -> top.put(palabra, top.getOrDefault(palabra, 0) + 1));

            List<Map.Entry<String, Integer>> top10 = top.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(10)
                    .toList();

            top10.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
