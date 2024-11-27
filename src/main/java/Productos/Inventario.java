package Productos;

public class Inventario {

    private long id;
    private long productoId;
    private int tallaId;
    private int colorId;
    private int cantidad;
    private double precioCompra;
    private double precioVenta;
    
    public Inventario() {
    }

    // Constructor completo
    public Inventario(long productoId, int tallaId, int colorId, int cantidad, double precioCompra, double precioVenta) {
        this.productoId = productoId;
        this.tallaId = tallaId;
        this.colorId = colorId;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    public int getTallaId() {
        return tallaId;
    }

    public void setTallaId(int tallaId) {
        this.tallaId = tallaId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
}
