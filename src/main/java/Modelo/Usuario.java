package Modelo;

import java.sql.Date;

public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String usuario;
    private String clave;
    private String estado;
    private String rol;
    private Date fechaNacimiento;
    private String foto;
    private Date fechaCreacion;
    private Profile profile;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String usuario, String estado, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.estado = estado;
        this.rol = rol;
    }

    public Usuario(String nombre, String apellido, String dni, String correo, String usuario, String clave, String estado, String rol, Date fechaNacimiento, String foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.foto = foto;
        this.profile = new Profile(foto);
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", correo=" + correo + ", usuario=" + usuario + ", clave=" + clave + ", estado=" + estado + ", rol=" + rol + ", fechaNacimiento=" + fechaNacimiento + ", foto=" + foto + ", fechaCreacion=" + fechaCreacion + '}';
    }

}
