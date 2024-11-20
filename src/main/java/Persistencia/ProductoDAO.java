package Persistencia;

import java.sql.*;
import java.util.*;

import Abstrac.DAO;
import Modelo.Perfil;
import Modelo.Producto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;

public class ProductoDAO extends DAO<Producto> {

    public List<Producto> obtenerTodosLosProductosDisponibles() {
        List<Producto> productos = listarTodo("SP_ObtenerProDisponibles");
        return productos;
    }

    @Override
    public Producto parsear(ResultSet rs) {
        Producto producto = new Producto();
        try {
            producto.setId(rs.getInt("id"));
            producto.setNombre(rs.getString("nombre"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setIdCategoria(rs.getInt("categoria_id"));
            producto.setPrecioCompra(rs.getDouble("precio_compra"));
            producto.setPrecioVenta(rs.getDouble("precio_venta"));
            Perfil perfil = new Perfil(rs.getBytes("Foto_Principal"));
            producto.setFoto_principal(perfil);
        } catch (SQLException e) {
            manejarError("Error al parcear Producto", e);
        }
        return producto;
    }

    public Producto obtenerProductoPorId(int productId) {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerProductoPorId'");
    }

    public void importarFotoPrueba(Producto producto) {
        int id = producto.getId();
        Perfil perfil = producto.getFoto_principal();
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC SP_ImagenesPrueba ?,?")) {
            cs.setInt(1, id);
            if (perfil != null && perfil.getRuta() != null) {
                cs.setBytes(2, getByteImagen(perfil.getRuta()));
            } else {
                cs.setNull(2, java.sql.Types.VARBINARY);
            }
            cs.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al importa imagen: " + e.toString());
        }
    }

    private byte[] getByteImagen(File file) throws IOException {
        BufferedImage imagen = Thumbnails.of(file)
                .height(500)
                .width(500)
                .outputQuality(0.7f)
                .asBufferedImage();
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            ImageIO.write(imagen, "jpg", out);
            byte[] data = out.toByteArray();
            return data;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
