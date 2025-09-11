import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Unidad 1 Actividad 2
 * @author Silvia Cachón Leiva
 */

public class Actividad2 {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

        System.out.println("Introduce el nombre del fichero: ");

        String nombreFichero = sc.nextLine();

        Path ruta = Path.of(nombreFichero);

        if (Files.exists(ruta) && Files.isRegularFile(ruta)) {

            System.out.println("¿Desea borrar el fichero: " +  nombreFichero + "?");
            System.out.println("""
                    1.SI
                    2.NO
                    """);
            int confirmacion = sc.nextInt();

            if (confirmacion == 1) {

                try {
                    Files.deleteIfExists(ruta);
                    System.out.println("Se ha eliminado el fichero");

                } catch (IOException e) {
                    System.err.println("No se ha podido eliminar el fichero");
                }

            }

        }

    }
}