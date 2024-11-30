package Modelo;

public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private double precioCompra;
    private double precioVenta;
    private boolean estadoPromocion;
    private Perfil fotoPrincipal;

    public Producto() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public boolean isEstadoPromocion() {
        return estadoPromocion;
    }

    public void setEstadoPromocion(boolean estadoPromocion) {
        this.estadoPromocion = estadoPromocion;
    }

    public Perfil getFotoPrincipal() {
        return fotoPrincipal;
    }

    public void setFotoPrincipal(Perfil fotoPrincipal) {
        this.fotoPrincipal = fotoPrincipal;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", estadoPromocion=" + estadoPromocion + ", fotoPrincipal=" + fotoPrincipal + '}';
    }
    
}
