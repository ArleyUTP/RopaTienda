package Modelo;

public class CarritoDetalles {
    private int idCarritoDetalle; // Singularizado el nombre
    private CarritoCompras carrito; // Relación al carrito
    private ProductoInventario productoInventario;
    private int cantidad;
    private double precio;
    private double subtotal; // Derivado: cantidad * precio

    public CarritoDetalles() {}

    public int getIdCarritoDetalle() {
        return idCarritoDetalle;
    }

    public void setIdCarritoDetalle(int idCarritoDetalle) {
        this.idCarritoDetalle = idCarritoDetalle;
    }

    public CarritoCompras getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoCompras carrito) {
        this.carrito = carrito;
    }

    public ProductoInventario getProductoInventario() {
        return productoInventario;
    }

    public void setProductoInventario(ProductoInventario productoInventario) {
        this.productoInventario = productoInventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        this.subtotal=cantidad * precio;
        return this.subtotal; // Calculado dinámicamente
    }
}
