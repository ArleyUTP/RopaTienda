package Modelo;

import java.util.Date;

public class Producto {

    private long id;
    private String codigo;
    private String nombre;
    private long categoriaId;
    private long tallaId;
    private long generoId;
    private long marcaId;
    private int stock;
    private int stockMinimo;
    private double precioCompra;
    private double precioVenta;
    private boolean estadoPromocion;
    private Date fechaCaducidadPromocion;
    private String foto;

    public Producto() {
    }

    public Producto(String codigo, String nombre, long categoriaId, long tallaId, long generoId, long marcaId, int stock, int stockMinimo, double precioCompra, double precioVenta, boolean estadoPromocion, Date fechaCaducidadPromocion, String foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoriaId = categoriaId;
        this.tallaId = tallaId;
        this.generoId = generoId;
        this.marcaId = marcaId;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.estadoPromocion = estadoPromocion;
        this.fechaCaducidadPromocion = fechaCaducidadPromocion;
        this.foto = foto;
    }

    public Producto(long id, String nombre, double precioVenta, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.foto = foto;
    }

    
    // Getters y Setters
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

    public long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public long getTallaId() {
        return tallaId;
    }

    public void setTallaId(long tallaId) {
        this.tallaId = tallaId;
    }

    public long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(long generoId) {
        this.generoId = generoId;
    }

    public long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(long marcaId) {
        this.marcaId = marcaId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
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

    public boolean isEstadoPromocion() {
        return estadoPromocion;
    }

    public void setEstadoPromocion(boolean estadoPromocion) {
        this.estadoPromocion = estadoPromocion;
    }

    public Date getFechaCaducidadPromocion() {
        return fechaCaducidadPromocion;
    }

    public void setFechaCaducidadPromocion(Date fechaCaducidadPromocion) {
        this.fechaCaducidadPromocion = fechaCaducidadPromocion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
