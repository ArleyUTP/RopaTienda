package Persistencia;

import java.sql.*;
import java.util.*;

import Abstrac.DAO;
import Modelo.Categoria;
import Modelo.Perfil;
import Modelo.Producto;
import Modelo.ProductoInventario;
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
            Categoria categoria = new Categoria();
            producto.setCategoria(categoria);
            producto.getCategoria().setId(rs.getInt("categoria_id"));
            producto.setPrecioCompra(rs.getDouble("precio_compra"));
            producto.setPrecioVenta(rs.getDouble("precio_venta"));
            Perfil perfil = new Perfil(rs.getBytes("foto_Principal"));
            producto.setFotoPrincipal(perfil);
            producto.setEstadoPromocion(rs.getBoolean("estado_promocion"));
        } catch (SQLException e) {
            manejarError("Error al parcear Producto", e);
        }
        return producto;
    }

    public boolean crearProductoConVariantes(Producto producto, List<ProductoInventario> variantes) {
        String procedimientoSQLProducto = "EXEC SP_CrearProductoConVariantes ?, ?, ?, ?, ?, ?, ?, ?";
        String procedimientoSQLVariantes = "EXEC SP_CrearVariantes ?, ?, ?, ?, ?";
        String procedimientoSQLImagenes = "EXEC SP_CrearImagenesInventario ?, ?";

        try (Connection con = getconection()) {
            con.setAutoCommit(false); // Iniciar transacción

            // Inserta el producto y obtiene el ID de salida
            int idProductoIngresado;
            try (CallableStatement cs = con.prepareCall(procedimientoSQLProducto)) {
                cs.setString(1, producto.getNombre());
                cs.setString(2, producto.getDescripcion());
                cs.setLong(3, producto.getCategoria().getId());
                cs.setDouble(4, producto.getPrecioCompra());
                cs.setDouble(5, producto.getPrecioVenta());
                cs.setBytes(6, producto.getFotoPrincipal() != null ? producto.getFotoPrincipal().getBytes() : null);
                cs.setBoolean(7, producto.isEstadoPromocion());
                cs.registerOutParameter(8, java.sql.Types.BIGINT); // Registro del parámetro de salida
                cs.executeUpdate();
                idProductoIngresado = cs.getInt(8); // Obtener el ID de salida
            }

            // Inserta las variantes y obtiene sus IDs en paralelo
            variantes.parallelStream().forEach(variante -> {
                try (CallableStatement cs2 = con.prepareCall(procedimientoSQLVariantes)) {
                    cs2.setInt(1, idProductoIngresado);
                    cs2.setInt(2, variante.getTalla().getId());
                    cs2.setInt(3, variante.getColorRopa().getId());
                    cs2.setInt(4, variante.getStock());
                    cs2.registerOutParameter(5, java.sql.Types.BIGINT); // Registro del parámetro de salida
                    cs2.executeUpdate();
                    int idVarianteIngresada = cs2.getInt(5); // Obtener el ID de salida

                    // Inserta las fotos de la variante en paralelo
                    variante.getFotos().parallelStream().forEach(foto -> {
                        try (CallableStatement cs3 = con.prepareCall(procedimientoSQLImagenes)) {
                            byte[] imgBytes = foto.getBytes();
                            cs3.setInt(1, idVarianteIngresada);
                            cs3.setBytes(2, imgBytes);
                            cs3.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace(); // Manejo de errores individual para cada foto
                        }
                    });
                } catch (SQLException e) {
                    e.printStackTrace(); // Manejo de errores individual para cada variante
                }
            });

            con.commit(); // Commit de la transacción si todo salió bien
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection con = getconection()) {
                if (con != null) {
                    con.rollback(); // Rollback en caso de error
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            return false;
        }
    }

//    public boolean actualizarProductoConVariantes(Producto producto, List<ProductoInventario> variantes) {
//        String procedimientoSQLProducto = "EXEC SP_ActualizarProducto ?, ?, ?, ?, ?, ?, ?, ?";
//        String procedimientoSQLVariantes = "EXEC SP_ActualizarVariante ?, ?, ?, ?, ?";
//        String procedimientoSQLFotos = "EXEC SP_ActualizarFotoInventario ?, ?, ?";
//
//        try (Connection con = getconection()) {
//            con.setAutoCommit(false); // Iniciar transacción
//
//            try (CallableStatement cs = con.prepareCall(procedimientoSQLProducto)) {
//                cs.setInt(1, producto.getId());
//                cs.setString(2, producto.getNombre());
//                cs.setString(3, producto.getDescripcion());
//                cs.setInt(4, producto.getCategoria().getId());
//                cs.setDouble(5, producto.getPrecioCompra());
//                cs.setDouble(6, producto.getPrecioVenta());
//                cs.setBytes(7, producto.getFotoPrincipal() != null ? producto.getFotoPrincipal().getBytes() : null);
//                cs.setBoolean(8, producto.isEstadoPromocion());
//                cs.executeUpdate();
//            } catch (Exception e) {
//                manejarError("Error al actualizar Producto", e);
//            }
//            // Actualizar las variantes y sus fotos
//            variantes.forEach(variante -> {
//                try (CallableStatement csVariante = con.prepareCall(procedimientoSQLVariantes)) {
//                    csVariante.setInt(1, variante.getIdVariante());
//                    System.out.println("El id variante es: " + variante.getIdVariante());
//                    csVariante.setInt(2, producto.getId());
//                    System.out.println("El id Producto es: " + producto.getId());
//                    csVariante.setInt(3, variante.getTalla().getId());
//                    csVariante.setInt(4, variante.getColorRopa().getId());
//                    csVariante.setInt(5, variante.getStock());
//                    csVariante.executeUpdate();
//                } catch (SQLException e) {
//                    throw new RuntimeException("Error al actualizar variante", e);
//                }
//
//                // Actualizar las fotos de la variante
//                variante.getFotos().forEach(foto -> {
//                    try (CallableStatement csFoto = con.prepareCall(procedimientoSQLFotos)) {
//                        csFoto.setInt(1, foto.getId());
//                        csFoto.setInt(2, variante.getIdVariante());
//                        csFoto.setBytes(3, foto.getBytes());
//                        csFoto.executeUpdate();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                });
//            });
//
//            con.commit(); // Commit de la transacción si todo salió bien
//            return true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            try (Connection con = getconection()) {
//                if (con != null) {
//                    con.rollback(); // Rollback en caso de error
//                }
//            } catch (SQLException rollbackEx) {
//                rollbackEx.printStackTrace();
//            }
//            return false;
//        }
//    }
    public boolean actualizarPrducto(Producto producto) {
        String procedimientoSQLProducto = "EXEC SP_ActualizarProducto ?, ?, ?, ?, ?, ?, ?, ?";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall(procedimientoSQLProducto)) {
            cs.setInt(1, producto.getId());
            cs.setString(2, producto.getNombre());
            cs.setString(3, producto.getDescripcion());
            cs.setInt(4, producto.getCategoria().getId());
            cs.setDouble(5, producto.getPrecioCompra());
            cs.setDouble(6, producto.getPrecioVenta());
            cs.setBytes(7, producto.getFotoPrincipal() != null ? producto.getFotoPrincipal().getBytes() : null);
            cs.setBoolean(8, producto.isEstadoPromocion());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            manejarError("Error al actualizar Producto", e);
            return false;
        }
    }

    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = listarTodo("SP_ObtenerTodosLosProductos");
        return productos;
    }
    public Producto obtenerProductoPorId(Producto producto){
        Producto productoEncontrado = new Producto();
        String sql = "EXEC SP_ObtenerProductoPorId ?";
        try (Connection con = getconection();CallableStatement cs = con.prepareCall(sql)){
            cs.setInt(1, producto.getId());
            try(ResultSet rs = cs.executeQuery()){
                if (rs.next()) {
                    productoEncontrado = parsear(rs);
                }
            }
        } catch (Exception e) {
            manejarError("Error al obtener producto por id", e);
        }
        return productoEncontrado;
    }
    private byte[] getByteImagen(File file) throws IOException {
        BufferedImage imagen = Thumbnails.of(file)
                .size(600, 600) // Ajustar a un tamaño moderado
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
