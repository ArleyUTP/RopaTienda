package Modelo;

import java.util.Date;
import java.util.List;

public class CarritoCompras {
    private int idCarrito;
    private Usuario usuario;
    private Date fechaCreacion; // Renombrado para usar camelCase
    private String estado;
    private int totalProductos; // Calculado o cargado desde la base de datos
    private List<CarritoDetalles> detalles; // Relación 1:N con los detalles

    public CarritoCompras() {}

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTotalProductos() {
        return totalProductos;
    }

    public void setTotalProductos(int totalProductos) {
        this.totalProductos = totalProductos;
    }

    public List<CarritoDetalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<CarritoDetalles> detalles) {
        this.detalles = detalles;
    }
}
