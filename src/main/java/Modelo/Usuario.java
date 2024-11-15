package Modelo;

import java.sql.Date;

public class Usuario {

    private int Id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String usuario;
    private String clave;
    private String estado;
    private String rol;
    private Date fechaNacimiento;
    private Perfil perfil;

    public Usuario(String nombre, String apellido, String dni, String correo, String usuario, String clave, String estado, String rol, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    private byte[] foto;
    private Date fechaCreacion;

    public Usuario() {
    }

    public Usuario(int Id, String nombre, String apellido, String usuario, String estado, String rol) {
        this.Id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.estado = estado;
        this.rol = rol;
    }

    public Usuario(String nombre, String apellido, String dni, String correo, String usuario, String clave, String estado, String rol, Date fechaNacimiento, byte[] foto, Date fechaCreacion) {
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
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario(String nombre, String apellido, String dni, String correo, String usuario, String clave, String estado, String rol, Date fechaNacimiento, Perfil perfil, byte[] foto, Date fechaCreacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.perfil = perfil;
        this.foto = foto;
        this.fechaCreacion = fechaCreacion;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Id=" + Id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", correo=" + correo + ", usuario=" + usuario + ", clave=" + clave + ", estado=" + estado + ", rol=" + rol + ", fechaNacimiento=" + fechaNacimiento + ", perfil=" + perfil + ", foto=" + foto + ", fechaCreacion=" + fechaCreacion + '}';
    }
    
}
