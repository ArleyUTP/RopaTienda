package Modelo;

import java.util.Objects;

public class ColorRopa {

    private int id;
    private String nombre;
    private String codigo_hexdecimal;

    public ColorRopa(String nombre, String codigo_hexdecimal) {
        this.nombre = nombre;
        this.codigo_hexdecimal = codigo_hexdecimal;
    }

    public ColorRopa() {
    }

    public String getCodigo_hexdecimal() {
        return codigo_hexdecimal;
    }

    public void setCodigo_hexdecimal(String codigo_hexdecimal) {
        this.codigo_hexdecimal = codigo_hexdecimal;
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
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ColorRopa other = (ColorRopa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.codigo_hexdecimal, other.codigo_hexdecimal);
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
