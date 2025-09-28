package Tarea1_4._1;

import java.util.Scanner;

/**
 * Clase principal que ejecuta el programa de inventario.
 * Muestra un menú para listar, añadir o modificar productos.
 */
public class Main {
    public static void main(String[] args) {
        // Crear objeto Inventario y cargar datos del archivo
        Inventario i = new Inventario();
        i.load();

        Scanner sc = new Scanner(System.in);
        int opc = 0; // Opción del menú

        // Bucle principal del menú
        while (opc != 4) {

            // Mostrar opciones
            System.out.println("""
                    1.Listar
                    2.Añadir
                    3.Modificar
                    4.Salir
                    """);

            // Leer opción del usuario
            opc = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            // Ejecutar acción según opción
            switch (opc) {
                case 1 -> i.listar();       // Listar todos los productos
                case 2 -> i.añadir();       // Añadir un nuevo producto
                case 3 -> i.modificar();    // Modificar stock de un producto
                case 4 -> System.out.println("Saliendo..."); // Salir del programa
                default -> System.out.println("Opción no válida"); // Opción incorrecta
            }
        }

        // Guardar cambios en el archivo al salir
        i.save();
    }
}
