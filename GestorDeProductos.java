import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestorDeProductos {
    private List<Producto> productos;
    public GestorDeProductos() {
        this.productos = new LinkedList<>();
    }
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }
    public List<Producto> obtenerProductos() {
        return productos;
    }
    public static void main(String[] args) {
        Scanner I = new Scanner(System.in);
        GestorDeProductos inventory = new GestorDeProductos();
        System.out.println("BIENVENIDO AL SISTEMA DE GESTIÓN DE PRODUCTOS DE JAVA");
        int option;
        String name;
        Double price;
        int stock;
        Producto product;
        long startTime, endTime;
        do {
            System.out.println("Ingresa una de las siguientes opciones");
            System.out.println("1) Agregar producto a inventario");
            System.out.println("2) Eliminar producto de inventario");
            System.out.println("3) Mostrar productos de inventario");
            System.out.println("4) Exportar productos en formato txt");
            System.out.println("5) Salir");
            option = I.nextInt();
            I.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del producto que desea añadir al inventario: ");
                    name = I.nextLine();
                    System.out.println("Ingrese el precio del producto que desea añadir al inventario: ");
                    price = I.nextDouble();
                    I.nextLine();
                    System.out.println("Ingrese el stock del producto que desea añadir al inventario: ");
                    stock = I.nextInt();
                    startTime = System.nanoTime();
                    product = new Producto(name, price, stock);
                    inventory.agregarProducto(product);
                    endTime = System.nanoTime();
                    long time = endTime - startTime;
                    System.out.println("Producto añadido correctamente al inventario");
                    System.out.println("Tiempo de ejecución: " + time);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del producto que desea eliminar del inventario: ");
                    name = I.nextLine();
                    startTime = System.nanoTime();
                    boolean eliminado = false;
                    for (Producto prod : inventory.productos) {
                        if (prod.nombre.equals(name)) {
                            inventory.productos.remove(prod);
                            eliminado = true;
                            break;
                        }
                    }
                    if (eliminado) {
                        endTime = System.nanoTime();
                        time = endTime - startTime;
                        System.out.println("Producto eliminado exitosamente.");
                        System.out.println("Tiempo de ejecución: " + time);
                    } else {
                        endTime = System.nanoTime();
                        time = endTime - startTime;
                        System.out.println("Producto no encontrado.");
                        System.out.println("Tiempo de ejecución: " + time);
                    }
                    break;
                case 3:
                    startTime = System.nanoTime();
                    if (inventory.productos.size() != 0) {
                        System.out.println(inventory.obtenerProductos());
                        endTime = System.nanoTime();
                        time = endTime - startTime;
                        System.out.println("Tiempo de ejecución: " + time);
                    } else {
                        System.out.println("No hay productos en el inventario");
                        endTime = System.nanoTime();
                        time = endTime - startTime;
                        System.out.println("Tiempo de ejecución: " + time);
                    }                    
                    break;
                case 4:
                    startTime = System.nanoTime();
                    guardaProductos file = new guardaProductos();
                    file.guardar(inventory.productos);
                    endTime = System.nanoTime();
                    time = endTime - startTime;
                    System.out.println("Archivo con inventario creado exitosamente.");
                    System.out.println("Tiempo de ejecución: " + time);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("El valor ingresado no corresponde a ninguna de las opciones disponibles.");
                    break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
        while (option != 5);
        I.close();
        System.out.println("GRACIAS POR UTILIZAR EL SISTEMA DE GESTIÓN DE PRODUCTOS DE JAVA.");
    } 
}

class Producto {
    String nombre;
    Double precio;
    Integer stock;

    public Producto(String nombre, double precio, Integer stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getStock() {
        return stock;
    }

    public void changeStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + ", Precio: " + precio + ", Stock: " + stock + "\n";    
    }
}     

interface guardarProductos {
   void guardar(List<Producto> productos);    
}

class guardaProductos implements guardarProductos {
    @Override
    public void guardar(List<Producto> productos) {
        try  (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
            for (Producto producto : productos) {
                writer.write("Nombre: "+producto.getNombre()+", Precio: "+producto.getPrecio()+", Stock: "+producto.getStock());
                writer.newLine();
            }       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


