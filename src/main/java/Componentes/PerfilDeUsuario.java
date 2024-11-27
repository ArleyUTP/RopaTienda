package Componentes;

import Modelo.Usuario;

public class PerfilDeUsuario extends javax.swing.JPanel {
    
    public PerfilDeUsuario() {
        initComponents();
    }
    
    public void loadData(Usuario usuario) {
        this.lbl_nombreCompleto.setText(usuario.getNombre() + " " + usuario.getApellido());
        this.lbl_correo.setText(usuario.getCorreo());
        this.lbl_estado.setText(usuario.getEstado());
        this.imageAvatar1.setImage(usuario.getPerfil().getIcon());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_nombreCompleto = new javax.swing.JLabel();
        lbl_correo = new javax.swing.JLabel();
        lbl_estado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        imageAvatar1 = new drawer.ImageAvatar();

        setOpaque(false);
        setLayout(new java.awt.GridLayout(1, 2, 0, 10));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 0, 10));

        lbl_nombreCompleto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombreCompleto.setText("Nombre Completo");
        jPanel1.add(lbl_nombreCompleto);

        lbl_correo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_correo.setText("Correo");
        jPanel1.add(lbl_correo);

        lbl_estado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_estado.setText("Estado");
        jPanel1.add(lbl_estado);

        add(jPanel1);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(imageAvatar1);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private drawer.ImageAvatar imageAvatar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_nombreCompleto;
    // End of variables declaration//GEN-END:variables
}
