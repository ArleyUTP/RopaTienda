package Modelo;

import java.util.Date;

public class OrdenPedido {
    private int id;
    private Date fecha_emision;
    private double importe_total;
    private String forma_pago;
    private String estado;
    private Cliente cliente;
    private Usuario vendedor;
    private CarritoCompras carritoCompras;
    public OrdenPedido() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFecha_emision() {
        return fecha_emision;
    }
    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }
    public double getImporte_total() {
        return importe_total;
    }
    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }
    public String getForma_pago() {
        return forma_pago;
    }
    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Usuario getVendedor() {
        return vendedor;
    }
    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }
    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }
    public void setCarritoCompras(CarritoCompras carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

}
