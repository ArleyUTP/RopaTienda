package Vista;

import Modelo.Usuario;
import Vista_Orden.CarritoCompra;
import Vista_Orden.GenerarOrder;
import com.formdev.flatlaf.FlatClientProperties;
import drawer.MyDrawerBuilder;
import drawer.MyDrawerBuilder1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import raven.drawer.Drawer;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.popup.component.SimplePopupBorderOption;

public class Menu_Principal extends javax.swing.JFrame {

    private Usuario usuario;

    public Menu_Principal(Usuario usuario) {
        GlassPanePopup.install(this);
        this.usuario = usuario;
        initComponents();
        carritoOfer_Item2.mostrarContador(this.usuario);
        carritoOfer_Item2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CarritoCompra visCarritoCompra = new CarritoCompra(usuario);
                visCarritoCompra.putClientProperty(FlatClientProperties.STYLE, ""
                        + "arc:25;" // Bordes redondeados
                        + "background:#FFFFFF"); // Fondo blanco
                visCarritoCompra.setPreferredSize(new Dimension(330, 600));
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancelar", "Generar Orden"};
                GlassPanePopup.showPopup(
                        new SimplePopupBorder(visCarritoCompra, "Carrito Compra", new SimplePopupBorderOption().setWidth(330), actions, (pc, i) -> {
                            if (i == 1) {
                                GenerarOrder generarOrder = new GenerarOrder(visCarritoCompra.getCarritoCompra());
                                contenedor.removeAll();
                                contenedor.add(generarOrder, BorderLayout.NORTH);
                                contenedor.revalidate();
                                contenedor.repaint();
                                pc.closePopup();
                            } else {
                                carritoOfer_Item2.mostrarContador(usuario);
                                pc.closePopup();
                            }
                        }),
                        option
                );
                carritoOfer_Item2.mostrarContador(usuario);
            }
        });
        perfil.cargarDatos(usuario);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setMaximizedBounds(this.getGraphicsConfiguration().getBounds());
        if (usuario.getRol().equals("admin")) {
            contenedor.setUsuarioActual(usuario);
            MyDrawerBuilder myDrawerBuilder = new MyDrawerBuilder(contenedor);
            Drawer drawer = Drawer.getInstance();
            drawer.setDrawerBuilder(myDrawerBuilder);
            javax.swing.JPanel drawerPanel = drawer.getDrawerPanel();
            if (drawerPanel != null) {
                drawerPanel.setBackground(Color.decode("#39E079"));
            }
        } else if (usuario.getRol().equals("vendedor")) {
            MyDrawerBuilder1 myDrawerBuilder1 = new MyDrawerBuilder1(contenedor);
            Drawer drawer = Drawer.getInstance();
            drawer.setDrawerBuilder(myDrawerBuilder1);
            javax.swing.JPanel drawerPanel = drawer.getDrawerPanel();
            if (drawerPanel != null) {
                drawerPanel.setBackground(Color.decode("#39E079"));
            }
        }
//        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Desktop\\UTP\\pinterest\\descarga (2)_x16_drawing.png"), "S/.1000", "12-10-2024"));
//        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\WHITE GLENN SHIRT - WHITE GLENN SHIRT.jpeg"), "S/.1000", "12-10-2024"));
//        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\Zapatos semiformales.jpeg"), "S/.1000", "12-10-2024"));
//        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\Zapatos semiformales.jpeg"), "S/.1000", "12-10-2024"));
//        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\Zapatos semiformales.jpeg"), "S/.1000", "12-10-2024"));
//        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\Zapatos semiformales.jpeg"), "S/.1000", "12-10-2024"));
//        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\Zapatos semiformales.jpeg"), "S/.1000", "12-10-2024"));
//        contenedorOfertas.revalidate();
//        contenedorOfertas.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();
        contenedor = new Vista.ContedorDePaneles();
        PanelSuperior = new javax.swing.JPanel();
        panelUsuario = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        carritoOfer_Item2 = new Componentes.CarritoOfer_Item();
        perfil = new Componentes.EncabezadoPerfilUsuario();
        contenedorOfertas = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setOpaque(false);
        panelPrincipal.setPreferredSize(new java.awt.Dimension(782, 631));
        panelPrincipal.setLayout(new java.awt.BorderLayout());
        panelPrincipal.add(contenedor, java.awt.BorderLayout.CENTER);

        PanelSuperior.setLayout(new javax.swing.BoxLayout(PanelSuperior, javax.swing.BoxLayout.Y_AXIS));

        panelUsuario.setOpaque(false);
        panelUsuario.setPreferredSize(new java.awt.Dimension(0, 60));
        panelUsuario.setLayout(new java.awt.BorderLayout());

        jPanel1.add(carritoOfer_Item2);
        jPanel1.add(perfil);

        panelUsuario.add(jPanel1, java.awt.BorderLayout.LINE_END);

        PanelSuperior.add(panelUsuario);

        contenedorOfertas.setPreferredSize(new java.awt.Dimension(782, 190));
        PanelSuperior.add(contenedorOfertas);

        panelPrincipal.add(PanelSuperior, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(panelPrincipal);

        jMenu1.setText("Menu");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_jMenu1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelSuperior;
    private Componentes.CarritoOfer_Item carritoOfer_Item2;
    private Vista.ContedorDePaneles contenedor;
    private javax.swing.JPanel contenedorOfertas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelUsuario;
    private Componentes.EncabezadoPerfilUsuario perfil;
    // End of variables declaration//GEN-END:variables
}
