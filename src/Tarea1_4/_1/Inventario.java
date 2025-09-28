package Tarea1_4._1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa un inventario de productos.
 * Permite cargar, guardar, listar, modificar y añadir productos.
 */
public class Inventario {
    List<Producto> productos; // Lista de productos del inventario
    int nuevoCodigo;          // Código que se asignará al siguiente producto

    /**
     * Carga los productos desde el archivo "inventario.dat".
     * Si no existe, crea una lista vacía.
     * Muestra mensajes claros si ocurre algún error.
     */
    public void load() {
        Path path = Path.of("inventario.dat");
        if (Files.exists(path)) {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
                productos = (List<Producto>) ois.readObject();
                System.out.println("Inventario cargado correctamente.");
            } catch (IOException e) {
                System.out.println("Error al leer el archivo de inventario: " + e.getMessage());
                productos = new ArrayList<>();
            } catch (ClassNotFoundException e) {
                System.out.println("Error: clase no encontrada al cargar inventario.");
                productos = new ArrayList<>();
            }
        } else {
            System.out.println("No se encontró el archivo inventario.dat. Se creará uno nuevo al guardar.");
            productos = new ArrayList<>();
        }
        nuevoCodigo = productos.size() + 1;
    }

    /**
     * Guarda los productos en el archivo "inventario.dat".
     * Si el archivo no existe, lo crea.
     * Muestra mensajes claros si ocurre algún error.
     */
    public void save() {
        Path path = Path.of("inventario.dat");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("Archivo inventario.dat creado.");
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
                oos.writeObject(productos);
                System.out.println("Inventario guardado correctamente.");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }

    /**
     * Lista todos los productos mostrando su código, nombre y stock.
     */
    public void listar() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto producto : productos) {
                System.out.println("Código: " + producto.getCodigo() +
                        " Nombre: " + producto.getNombre() +
                        " Stock: " + producto.getStock());
            }
        }
    }

    /**
     * Modifica el stock de un producto según su código.
     * Muestra un mensaje si el producto no existe.
     */
    public void modificar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Código de producto: ");
        int codigo = sc.nextInt();
        System.out.println("Introduce stock: ");
        int stock = sc.nextInt();

        Producto p = new Producto();
        p.setCodigo(codigo);

        if (productos.contains(p)) {
            productos.get(productos.indexOf(p)).setStock(stock);
            System.out.println("Stock modificado correctamente.");
        } else {
            System.out.println("Error: producto con código " + codigo + " no encontrado.");
        }
    }

    /**
     * Añade un nuevo producto al inventario solicitando nombre y stock.
     */
    public void añadir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce stock: ");
        int stock = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Producto p = new Producto();
        p.setNombre(nombre);
        p.setStock(stock);
        p.setCodigo(nuevoCodigo);

        productos.add(p);
        nuevoCodigo++;

        System.out.println("Producto añadido correctamente: " + nombre);
    }
}
