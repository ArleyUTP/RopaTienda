package Modelo;

import java.util.Date;

public class Comprobante {
    private long id;
    private OrdenPedido ordenPedido; 
    private String tipo; // Tipo de comprobante (Factura/Boleta)
    private String serie; 
    private int correlativo; 
    private String totalLetras; 
    private Date fechaEmision;
    private double subtotal;
    private double totalIva;
    private double totalAPagar;

    public Comprobante() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrdenPedido getOrdenPedido() {
        return ordenPedido;
    }

    public void setOrdenPedido(OrdenPedido ordenPedido) {
        this.ordenPedido = ordenPedido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public String getTotalLetras() {
        // Genera el total en letras a partir del total a pagar
        NumeroALetraPeru conversor = new NumeroALetraPeru();
        totalLetras = conversor.convertir(String.format("%.2f", getTotalAPagar()), true);
        return totalLetras;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotalIva() {
        final double IVA = 0.18;
        if ("Factura".equalsIgnoreCase(tipo) || ("Boleta".equalsIgnoreCase(tipo) && subtotal > 750)) {
            totalIva = subtotal * IVA;
        } else {
            totalIva = 0;
        }
        // Redondear a 2 decimales
        totalIva = Math.round(totalIva * 100.0) / 100.0;
        return totalIva;
    }
    
    public double getTotalAPagar() {
        totalAPagar = getSubtotal() + getTotalIva();
        // Redondear a 2 decimales
        totalAPagar = Math.round(totalAPagar * 100.0) / 100.0;
        return totalAPagar;
    }
    
}
