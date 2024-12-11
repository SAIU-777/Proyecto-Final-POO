 import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaInventarios {
    private static Scanner scanner = new Scanner(System.in);
    private static Inventario inventario = new Inventario();

    // Mostrar menu
    public static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("   Bienvenido al Sistema de Gestion de Inventarios");
        System.out.println("========================================");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Mostrar Productos");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Mostrar Proveedores");
        System.out.println("5. Buscar Producto por Codigo");
        System.out.println("6. Salir");
        System.out.println("\n========================================");
    }

    // Ejecutar el sistema
    public static void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
            while (!scanner.hasNextInt()) {
                System.out.println("\n Error! Ingrese una opcion valida (un numero entero).");
                scanner.next(); // Limpiar el buffer
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Para consumir el salto de linea

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    inventario.mostrarProductos();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    inventario.mostrarProveedores();
                    break;
                case 5:
                    buscarProducto();
                    break;
                case 6:
                    System.out.println("\n Gracias por usar el sistema! Hasta pronto.");
                    break;
                default:
                    System.out.println("\n Opcion invalida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 6);
    }

    // Agregar producto
    public static void agregarProducto() {
        System.out.print("\n Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        
        double precio = 0;
        // Validacion para el precio
        boolean precioValido = false;
        while (!precioValido) {
            System.out.print("Ingrese el precio del producto: ");
            try {
                precio = scanner.nextDouble();
                if (precio < 0) {
                    System.out.println("\n El precio no puede ser negativo. Intente nuevamente.");
                } else {
                    precioValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n Error! El precio debe ser un numero valido.");
                scanner.next(); // Limpiar el buffer
            }
        }

        int cantidad = 0;
        // Solicitar que la cantidad sea mayor a 10
        do {
            System.out.print("Ingrese la cantidad del producto (mayor a 10): ");
            while (!scanner.hasNextInt()) {
                System.out.println("\n Error! Ingrese un numero valido para la cantidad.");
                scanner.next(); // Limpiar el buffer
            }
            cantidad = scanner.nextInt();

            // Si la cantidad es menor a 10, mostrar mensaje de error
            if (cantidad < 10) {
                System.out.println("\n Error! POR FAVOR INGRESE UNA CANTIDAD MAYOR A 10 PARA INGRESAR ESTE INVENTARIO A BODEGA.");
            }
        } while (cantidad < 10);  // Repetir hasta que la cantidad sea mayor o igual a 10

        scanner.nextLine(); // Para consumir el salto de linea
        System.out.print("Ingrese el nombre del proveedor: ");
        String proveedorNombre = scanner.nextLine();

        // Generar codigo aleatorio de 3 cifras
        int codigo = (int) (Math.random() * 900) + 100;

        Proveedor proveedor = new Proveedor(proveedorNombre);
        Producto producto = new Producto(codigo, nombre, precio, cantidad, proveedor);
        inventario.agregarProveedor(proveedor);
        inventario.agregarProducto(producto);

        System.out.println("\n Producto agregado con exito.\n");
    }

    // Eliminar producto
    public static void eliminarProducto() {
        int codigo = 0;
        // Validacion para el codigo de producto
        boolean codigoValido = false;
        while (!codigoValido) {
            System.out.print("\n Ingrese el codigo del producto a eliminar: ");
            try {
                codigo = scanner.nextInt();
                codigoValido = true;
            } catch (InputMismatchException e) {
                System.out.println("\n Error! El codigo debe ser un numero valido.");
                scanner.next(); // Limpiar el buffer
            }
        }

        if (inventario.eliminarProducto(codigo)) {
            System.out.println("\n Producto eliminado con exito.\n");
        } else {
            System.out.println("\n Producto no encontrado.\n");
        }
    }

    // Buscar producto por codigo
    public static void buscarProducto() {
        int codigo = 0;
        // Validacion para el codigo de producto
        boolean codigoValido = false;
        while (!codigoValido) {
            System.out.print("\n Ingrese el codigo del producto a buscar: ");
            try {
                codigo = scanner.nextInt();
                codigoValido = true;
            } catch (InputMismatchException e) {
                System.out.println("\n Error! El codigo debe ser un numero valido.");
                scanner.next(); // Limpiar el buffer
            }
        }

        Producto producto = inventario.buscarProductoPorCodigo(codigo);

        if (producto != null) {
            System.out.println("\n Producto encontrado: " + producto + "\n");
        } else {
            System.out.println("\n Producto no encontrado.\n");
        }
    }

    public static void main(String[] args) {
        ejecutar();
    }
}
