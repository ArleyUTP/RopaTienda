package Modelo;

public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private int idCategoria;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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

    public Producto(int id, String nombre, String descripcion, int idCategoria, double precioCompra, double precioVenta, boolean estadoPromocion, Perfil fotoPrincipal) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.estadoPromocion = estadoPromocion;
        this.fotoPrincipal = fotoPrincipal;
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

}
