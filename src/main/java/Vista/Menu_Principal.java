package Vista;

import Componentes.Ofertas_Item;
import Modelo.Usuario;
import drawer.MyDrawerBuilder;
import drawer.MyDrawerBuilder1;
import java.awt.Color;
import javax.swing.ImageIcon;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;

public class Menu_Principal extends javax.swing.JFrame {
    
    private Usuario usuario;
    
    public Menu_Principal(Usuario usuario) {
        GlassPanePopup.install(this);
        this.usuario = usuario;
        initComponents();
        perfil.cargarDatos(usuario);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setMaximizedBounds(this.getGraphicsConfiguration().getBounds());
        if (usuario.getRol().equals("admin")) {
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
        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Desktop\\UTP\\pinterest\\descarga (2)_x16_drawing.png"), "S/.1000", "12-10-2024"));
        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\WHITE GLENN SHIRT - WHITE GLENN SHIRT.jpeg"), "S/.1000", "12-10-2024"));
        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\Zapatos semiformales.jpeg"), "S/.1000", "12-10-2024"));
        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\Zapatos semiformales.jpeg"), "S/.1000", "12-10-2024"));
        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\Zapatos semiformales.jpeg"), "S/.1000", "12-10-2024"));
        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\Zapatos semiformales.jpeg"), "S/.1000", "12-10-2024"));
        contenedorOfertas.add(new Ofertas_Item(new ImageIcon("C:\\Users\\user\\Downloads\\Zapatos semiformales.jpeg"), "S/.1000", "12-10-2024"));
        contenedorOfertas.revalidate();
        contenedorOfertas.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        PanelSuperior = new javax.swing.JPanel();
        panelUsuario = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        carritoOfer_Item1 = new Componentes.CarritoOfer_Item();
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

        contenedor.setLayout(new java.awt.BorderLayout());
        panelPrincipal.add(contenedor, java.awt.BorderLayout.CENTER);

        PanelSuperior.setLayout(new javax.swing.BoxLayout(PanelSuperior, javax.swing.BoxLayout.Y_AXIS));

        panelUsuario.setOpaque(false);
        panelUsuario.setPreferredSize(new java.awt.Dimension(0, 60));
        panelUsuario.setLayout(new java.awt.BorderLayout());

        carritoOfer_Item1.setPreferredSize(new java.awt.Dimension(50, 60));
        jPanel1.add(carritoOfer_Item1);
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

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Menu_Principal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelSuperior;
    private Componentes.CarritoOfer_Item carritoOfer_Item1;
    private javax.swing.JPanel contenedor;
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
