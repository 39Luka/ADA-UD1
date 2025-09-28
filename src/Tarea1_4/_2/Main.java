package Tarea1_4._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    static Properties properties = new Properties();
    static Properties properties1 = new Properties();
    static Properties effective = new Properties();

    public static void main(String[] args) {
        cargarProperties();
        mostrarProperties();
        System.out.println("========");

        Scanner sc = new Scanner(System.in);
        cargarProperties();

        String linea;

        System.out.println("Consola de configuración. Comandos: env, list, get <clave>, exit");

        while (true) {
            System.out.print("> ");
            linea = sc.nextLine().trim();

            if (linea.equalsIgnoreCase("exit")) {
                System.out.println("Saliendo...");
                break;
            } else if (linea.equalsIgnoreCase("env")) {
                System.out.println("Entorno activo: " + getEnv());
            } else if (linea.equalsIgnoreCase("list")) {
                mostrarProperties();
            } else if (linea.startsWith("get ")) {
                String clave = linea.substring(4).trim();
                encontrarPropiedad(clave);
            } else {
                System.out.println("Comando no reconocido. Usa: env, list, get <clave>, exit");
            }

        }
    }


    private static void mostrarMenu(String x) {
        System.out.println(x);
    }

    private static void cargarProperties() {
        try (BufferedReader br = Files.newBufferedReader(Path.of("app.properties"))) {
            properties.load(br);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String env = getEnv();

        try (BufferedReader br1 = Files.newBufferedReader(Path.of("app." + env + ".properties"))) {
            properties1.load(br1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        effective.putAll(properties);
        effective.putAll(properties1);
    }


    private static String getEnv() {
        return properties.getProperty("app.env");
    }

    public static void mostrarProperties() {
        System.out.println("Propiedades: ");
        effective.forEach((c, v) -> System.out.println(c + ":" + v));
    }

    public static void encontrarPropiedad(String propiedad) {
        System.out.println(effective.get(propiedad));
    }
}
