package Modelo;

public class Provincia {
    private int id;
    private String nombre;
    private Departamento Departamento ;
    public Provincia() {
    }
    
    public Provincia(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    @Override
    public String toString() {
        return this.nombre;
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
        Provincia other = (Provincia) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
}
