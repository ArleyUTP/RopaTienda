    package Modelo;

import java.sql.Date;

public class Producto {

    private long id;
    private String codigo;
    private String nombre;
    private long idCategoria;
    private long stock;
    private long stockMinimo;
    private double precioCompra;
    private double precioVenta;
    private boolean estadoPromocion;
    private Date fechaCaducidadPromoción;
    private String foto;

    public Producto() {
    }

    public Producto(long id, String nombre, double precioVenta, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.foto = foto;
    }

    public Producto(String codigo, String nombre, long idCategoria, long stock, long stockMinimo, double precioCompra, double precioVenta, boolean estadoPromocion, Date fechaCaducidadPromoción, String foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.estadoPromocion = estadoPromocion;
        this.fechaCaducidadPromoción = fechaCaducidadPromoción;
        this.foto = foto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public long getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(long stockMinimo) {
        this.stockMinimo = stockMinimo;
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

    public boolean getEstadoPromocion() {
        return estadoPromocion;
    }

    public void setEstadoPromocion(boolean estadoPromocion) {
        this.estadoPromocion = estadoPromocion;
    }

    public Date getFechaCaducidadPromoción() {
        return fechaCaducidadPromoción;
    }

    public void setFechaCaducidadPromoción(Date fechaCaducidadPromoción) {
        this.fechaCaducidadPromoción = fechaCaducidadPromoción;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
}
