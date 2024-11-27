package Modelo;

public class Inventario {

    private Producto producto;
    private ColorRopa colorRopa;
    private Talla tallaProducto;
    private Perfil fotoProducto;

    public Inventario(Producto producto, ColorRopa colorRopa, Talla tallaProducto, Perfil fotoProducto) {
        this.producto = producto;
        this.colorRopa = colorRopa;
        this.tallaProducto = tallaProducto;
        this.fotoProducto = fotoProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ColorRopa getColorRopa() {
        return colorRopa;
    }

    public void setColorRopa(ColorRopa colorRopa) {
        this.colorRopa = colorRopa;
    }

    public Talla getTallaProducto() {
        return tallaProducto;
    }

    public void setTallaProducto(Talla tallaProducto) {
        this.tallaProducto = tallaProducto;
    }

    public Perfil getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(Perfil fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

}
