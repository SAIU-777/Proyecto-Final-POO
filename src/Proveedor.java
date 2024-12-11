 public class Proveedor {
    private String nombre;

    // Constructor
    public Proveedor(String nombre) {
        this.nombre = nombre;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Metodo toString
    @Override
    public String toString() {
        return nombre;
    }
}
