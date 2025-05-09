package Modelo;

public class Departamento {
    private int id;
    private String nombre;
    
    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Departamento() {
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Departamento other = (Departamento) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return this.nombre;
    }
    
}
