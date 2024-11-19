package Componentes;

import Modelo.Usuario;

public class Encabezado extends javax.swing.JPanel {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Encabezado() {
        initComponents();
        texto();
    }

    private void texto() {
        this.lbl_nombreCompleto.setText(usuario.getNombre() + " " + usuario.getApellido());
        this.lbl_correo.setText(usuario.getCorreo());
        this.lbl_estado.setText(usuario.getEstado());
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

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        lbl_nombreCompleto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombreCompleto.setText("Nombre Completo");
        jPanel1.add(lbl_nombreCompleto);

        lbl_correo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_correo.setText("Correo");
        jPanel1.add(lbl_correo);

        lbl_estado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_estado.setText("Estado");
        jPanel1.add(lbl_estado);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));
        jPanel2.add(imageAvatar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
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
