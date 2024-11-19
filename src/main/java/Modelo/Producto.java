    package Modelo;


public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private int idCategoria;
    private double precioCompra;
    private double precioVenta;
    private Perfil foto_principal;
    
    public Producto() {
    }
    public Producto(String nombre, String descripcion, int idCategoria, double precioCompra, double precioVenta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getPrecioCompra() {
        return this.precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return this.precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Perfil getFoto_principal() {
        return foto_principal;
    }

    public void setFoto_principal(Perfil foto_principal) {
        this.foto_principal = foto_principal;
    }

}
