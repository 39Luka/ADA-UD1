package Tarea1_4._1;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Inventario {
    List<Producto> productos;
    int nuevoCodigo;

    public void load() {
        Path path = Path.of("inventario.dat");
        if (Files.exists(path))
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
                productos = (List<Producto>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        else {
            productos = new ArrayList<>();
        }
        nuevoCodigo = productos.size() + 1;
    }

    public void save() {
        Path path = Path.of("inventario.dat");
        if (Files.exists(path))
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
                oos.writeObject(productos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

    public void listar() {
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " " + producto.getStock());
        }
    }

    public void modificar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Codigo de producto: ");
        int codigo = sc.nextInt();
        System.out.println("Introduce stock: ");
        int stock = sc.nextInt();
        Producto p = new Producto();
        p.setCodigo(codigo);
        if (productos.contains(p)) {
            productos.get(productos.indexOf(p)).setStock(stock);
        }
    }

    public void añadir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce stock: ");
        int stock = sc.nextInt();
        sc.nextLine();
        Producto p = new Producto();
        p.setNombre(nombre);
        p.setStock(stock);
        p.setCodigo(nuevoCodigo);
        productos.add(p);
        nuevoCodigo++;
    }



}

