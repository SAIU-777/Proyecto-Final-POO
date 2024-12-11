 public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private Proveedor proveedor;

    // Constructor
    public Producto(int codigo, String nombre, double precio, int cantidad, Proveedor proveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
    }

    // Metodos Getter y Setter
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Metodo toString para mostrar los datos del producto
    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad + ", Proveedor: " + proveedor.getNombre();
    }
}
