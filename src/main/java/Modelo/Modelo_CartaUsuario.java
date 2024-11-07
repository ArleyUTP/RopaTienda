package Modelo;

public class Modelo_CartaUsuario {

    private String nombre;
    private String apellido;
    private String estado;
    private String rol;

    public Modelo_CartaUsuario(String nombre, String apellido, String estado, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
