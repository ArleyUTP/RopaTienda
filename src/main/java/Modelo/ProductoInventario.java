package Modelo;

import java.util.List;

public class ProductoInventario {

    private int idVariante;
    private Producto producto;
    private Talla talla;
    private ColorRopa colorRopa;
    private int stock;
    private List<Perfil> fotos;

    public ProductoInventario() {
    }

    public int getIdVariante() {
        return idVariante;
    }

    public void setIdVariante(int idVariante) {
        this.idVariante = idVariante;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public ColorRopa getColorRopa() {
        return colorRopa;
    }

    public void setColorRopa(ColorRopa colorRopa) {
        this.colorRopa = colorRopa;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Perfil> getFotos() {
        return fotos;
    }

    public void setFotos(List<Perfil> fotos) {
        this.fotos = fotos;
    }

}
