package Tarea1_4._2.config;

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
        menu();

        int opc;
        opc = sc.nextInt();
        sc.nextLine();

        while (opc != 4) {

            switch (opc) {
                case 1 -> {
                    System.out.println("Nombre propiedad: ");
                    String nombre = sc.nextLine();
                    encontrarPropiedad(nombre);

                }
                case 2 -> mostrarProperties();
                case 3 -> System.out.println(getEnv());

            }
            menu();
            opc = sc.nextInt();
            sc.nextLine();

        }
    }

    private static void menu() {
        mostrarMenu("""
                1.Consultar clave
                2.Listar claves
                3.Ver entorno activo
                """);
    }

    private static void mostrarMenu(String x) {
        System.out.println(x);
    }

    private static void cargarProperties() {
        try(BufferedReader br = Files.newBufferedReader(Path.of("app.properties"))) {
            properties.load(br);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        String env = getEnv();

        try (BufferedReader br1 = Files.newBufferedReader(Path.of("app."+env+".properties"))){
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

    public static void mostrarProperties(){
        System.out.println("Propiedades: ");
        effective.forEach((c,v) -> System.out.println(c+":"+v));
    }

    public static void encontrarPropiedad (String propiedad){
        System.out.println(effective.get(propiedad));
    }
}
