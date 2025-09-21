package Tarea1_2._2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Actividad1 {
    public static void main(String[] args) {

        Path origen = Path.of("correos.txt");
        Path destino = Path.of("emails_extraidos.txt");

        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern email = Pattern.compile(regex);

        Set<String> emails = new HashSet<>();

        try {
            Stream<String> lineas = Files.lines(origen);
            lineas.forEach(linea -> {
                        Matcher matcher = email.matcher(linea);
                        while (matcher.find()){
                            emails.add(matcher.group());
                        }
                    }
            );


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.write(destino, emails);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
