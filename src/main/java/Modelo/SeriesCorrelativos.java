package Modelo;

public class SeriesCorrelativos {
    private long id;
    private String tipo;
    private String serie;
    private int correlativoActual;

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getCorrelativoActual() {
        return correlativoActual;
    }

    public void setCorrelativoActual(int correlativoActual) {
        this.correlativoActual = correlativoActual;
    }
}

