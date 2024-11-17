package Vista;

import Modelo.Usuario;
import Vista_Usuarios.Man_Usuarios;
import drawer.Encabezado;
import java.awt.BorderLayout;
import java.awt.Color;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import raven.popup.GlassPanePopup;
import raven.toast.Notifications;

public class Menu_Principal extends javax.swing.JFrame {

    private DrawerController drawer;

    public Menu_Principal(Usuario usuario) {
        System.out.println("Usuario en el menu principal es: " + usuario.toString());
        GlassPanePopup.install(this);
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setMaximizedBounds(this.getGraphicsConfiguration().getBounds());
        init();
        this.drawer = Drawer.newDrawer(this)
                .header(new Encabezado(usuario))
                .separator(2, Color.BLACK)
                .background(Color.WHITE) // Color verde esmeralda
                .drawerBackground(Color.decode("#00FF7F")) // Fondo blanco
                .enableScroll(true)
                .space(3)
                .duration(300) // Animación más rápida
                .resolution(20) // Mejora la suavidad de la animación
                .itemHeight(50)
                .addChild(new DrawerItem("Menu Principal").icon(new ImageIcon(getClass().getResource(""))).build())
                .addChild(new DrawerItem("Usuarios").icon(new ImageIcon(getClass().getResource(""))).build())
                .addChild(new DrawerItem("Menu Principal").icon(new ImageIcon(getClass().getResource(""))).build())
                .addFooter(new DrawerItem("Exit").icon(new ImageIcon(getClass().getResource(""))).build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem di) {
                        switch (i) {
                            case 1 -> {
                                Man_Usuarios man_Usuarios = new Man_Usuarios();
                                contenedor.setLayout(new BorderLayout());
                                contenedor.removeAll(); // Asegúrate de limpiar antes de añadir
                                contenedor.add(man_Usuarios, BorderLayout.CENTER);
                                contenedor.revalidate();
                                contenedor.repaint();
                            }
                            case 2 -> {
                            }
                        }
                    }
                })
                .build();
        cargarCajon();
    }

    private void cargarCajon() {
    }

    private void init() {
        Notifications.getInstance().setJFrame(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenedor.setPreferredSize(new java.awt.Dimension(782, 631));

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        jMenu1.setText("Menu");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }

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
    private javax.swing.JPanel contenedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
