package utils;

public class Empleado {
    private int id;
    private String nombre;
    private String departamento;

    // Constructor
    public Empleado(int id, String nombre, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    // Overriding toString para facilitar la visualización
    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
