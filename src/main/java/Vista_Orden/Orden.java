package Vista_Orden;

import Modelo.CarritoCompras;
import Modelo.CarritoDetalles;
import Modelo.Producto;
import Modelo.Usuario;
import Persistencia.CarritoComprasDAO;
import Persistencia.CarritoDetallesDAO;
import Persistencia.ProductoDAO;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.popup.component.SimplePopupBorderOption;
import raven.toast.Notifications;

public class Orden extends javax.swing.JPanel {

    Usuario usuarioActual;

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public Orden() {
        initComponents();
        init();
    }

    private void init() {
        contenedor.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
        CargarDatos();
    }

    private void CargarDatos() {
        ProductoDAO productoDAO = new ProductoDAO();
        List<Producto> productoDisponibles = productoDAO.obtenerTodosLosProductosDisponibles();
        contenedor.setLayout(new GridLayout(0, 3, 80, 80));  // Configura GridLayout (3 columnas y márgenes de 30px)
        productoDisponibles.forEach(producto -> {
            CartaProductos carta = new CartaProductos(producto);
            carta.setPreferredSize(new java.awt.Dimension(300, 500));  // Ajusta el tamaño preferido de cada carta
            carta.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Productos_Detalles productos_Detalles = new Productos_Detalles(producto);
                    DefaultOption option = new DefaultOption() {
                        @Override
                        public boolean closeWhenClickOutside() {
                            return true;
                        }
                    };
                    String actions[] = new String[]{"Cancelar", "Agregar al Carrito"};
                    GlassPanePopup.showPopup(
                            new SimplePopupBorder(productos_Detalles, "Agregar Producto", new SimplePopupBorderOption().setWidth(590), actions, (pc, i) -> {
                                if (i == 1) {
                                    CarritoComprasDAO carritoComprasDAO = new CarritoComprasDAO();
                                    CarritoDetallesDAO carritoDetallesDAO = new CarritoDetallesDAO();
                                    CarritoDetalles carritoDetalles = productos_Detalles.obtenerDatos();
                                    CarritoCompras carritoCompra = new CarritoCompras();
                                    carritoCompra.setUsuario(usuarioActual);
                                    int idCarritoActual = carritoComprasDAO.obtenerOCrearCarritoCompras(carritoCompra);
                                    if (idCarritoActual != 0) {
                                        if (carritoDetalles.getProductoInventario().getIdVariante() != 0) {
                                            carritoCompra.setIdCarrito(idCarritoActual);
                                            carritoDetalles.setCarrito(carritoCompra);
                                            boolean exito = carritoDetallesDAO.crearCarritoDetalle(carritoDetalles);
                                            if (exito) {
                                                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Producto agregado correctamente al carrito.");
                                            } else {
                                                Notifications.getInstance().show(Notifications.Type.ERROR, "No se pudo agregar el producto al carrito. Verifique el stock.");
                                            }
                                            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Agregado Correcto al carrito");
                                            pc.closePopup();
                                        }
                                    } else {
                                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Agregado Correcto al carrito");
                                        pc.closePopup();
                                    }
                                } else {
                                    pc.closePopup();
                                }
                            }),
                            option
                    );
                }

            });
            contenedor.add(carta);
        });
        contenedor.revalidate();  // Reorganiza el layout
        contenedor.repaint();     // Redibuja los componentes
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        contenedor = new javax.swing.JPanel();

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(contenedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
