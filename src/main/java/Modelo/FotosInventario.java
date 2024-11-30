package Modelo;

public class FotosInventario {
    private int id;
    private int idInventario;
    private Perfil imagen;
    public FotosInventario() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdInventario() {
        return idInventario;
    }
    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }
    public Perfil getImagen() {
        return imagen;
    }
    public void setImagen(Perfil imagen) {
        this.imagen = imagen;
    }
    
}
