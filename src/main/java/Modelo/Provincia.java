package Modelo;

public class Provincia {
    private int id;
    private String nombre;
    private Departamento Departamento ;
    public Provincia() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Departamento getDepartamento() {
        return Departamento;
    }
    public void setDepartamento(Departamento departamento) {
        Departamento = departamento;
    }

}
