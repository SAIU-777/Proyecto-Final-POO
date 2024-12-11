 import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Proveedor> proveedores = new ArrayList<>();

    // Metodo para agregar un producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public boolean eliminarProducto(int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                // Eliminar el proveedor del producto
                Proveedor proveedorAEliminar = producto.getProveedor();
                proveedores.remove(proveedorAEliminar);
                
                // Eliminar el producto
                productos.remove(producto);
                System.out.println("Producto y su proveedor eliminados con exito.");
                return true;
            }
        }
        return false;
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            // Imprimir la cabecera de la tabla
            System.out.println("-------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-20s |\n", "Codigo", "Nombre", "Precio", "Cantidad", "Proveedor");
            System.out.println("-------------------------------------------------------------");

            // Imprimir los productos en formato de tabla
            for (Producto producto : productos) {
                System.out.printf("| %-10d | %-20s | %-10.2f | %-10d | %-20s |\n",
                        producto.getCodigo(), producto.getNombre(), producto.getPrecio(),
                        producto.getCantidad(), producto.getProveedor().getNombre());
            }

            System.out.println("-------------------------------------------------------------");
        }
    }

    // Metodo para mostrar todos los proveedores
    public void mostrarProveedores() {
        if (proveedores.isEmpty()) {
            System.out.println("\nNo hay proveedores registrados.");
        } else {
            System.out.println("\nLista de Proveedores:");
            for (Proveedor proveedor : proveedores) {
                System.out.println(proveedor);
            }
        }
    }

    // Metodo para buscar un producto por codigo
    public Producto buscarProductoPorCodigo(int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }

    // Metodo para agregar un proveedor
    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    int generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
