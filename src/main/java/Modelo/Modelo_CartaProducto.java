package Modelo;

import javax.swing.Icon;

public class Modelo_CartaProducto {
    private String nombre;
    private String categoria;
    private String marca;
    private int stock;
    private double precio;
    Icon imagen;

    public Modelo_CartaProducto(String nombre, String categoria, String marca, int stock, double precio, Icon imagen) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca = marca;
        this.stock = stock;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Modelo_CartaProducto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Icon getImagen() {
        return imagen;
    }

    public void setImagen(Icon imagen) {
        this.imagen = imagen;
    }
    
}
