import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 Unidad 1 Actividad 1
 @author Silvia Cachón Leiva
 */

public class Actividad1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una ruta:");

        String nombreRuta = sc.nextLine();

        Path ruta = Paths.get(nombreRuta);

        if( Files.exists(ruta) && Files.isDirectory(ruta)) {

            try {
                DirectoryStream<Path> paths = Files.newDirectoryStream(ruta);

                paths.forEach(path -> {

                    if (Files.isDirectory(path))
                        System.out.println("Directorio" + path);

                    else if (Files.isRegularFile(path))
                        System.out.println("Fichero" + path);

                });


            } catch (IOException e) {

                System.err.println(e.getMessage());
            }

        }
    }
}