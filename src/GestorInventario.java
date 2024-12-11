 import java.util.Scanner;

public class GestorInventario {
    private Inventario inventario = new Inventario();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("Bienvenido al Sistema de Gestion de Inventarios");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Mostrar Productos");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Mostrar Proveedores");
        System.out.println("5. Buscar Producto por Codigo");
        System.out.println("6. Salir");
    }

    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
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
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 6);
    }

    public void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        int cantidad;

        // Solicitar que la cantidad sea mayor a 10
        do {
            System.out.print("Ingrese la cantidad del producto (mayor a 10): ");
            cantidad = scanner.nextInt();

            // Si la cantidad es menor a 10, mostrar mensaje de error en rojo
            if (cantidad < 10) {
                System.out.println("\u001B[31mPOR FAVOR INGRESE UNA CANTIDAD MAYOR A 10 PARA INGRESAR ESTE INVENTARIO A BODEGA\u001B[0m");
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

        System.out.println("Producto agregado con exito.");
    }

    public void eliminarProducto() {
        System.out.print("Ingrese el codigo del producto a eliminar: ");
        int codigo = scanner.nextInt();

        if (inventario.eliminarProducto(codigo)) {
            System.out.println("Producto eliminado con exito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void buscarProducto() {
        System.out.print("Ingrese el codigo del producto a buscar: ");
        int codigo = scanner.nextInt();

        Producto producto = inventario.buscarProductoPorCodigo(codigo);

        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
