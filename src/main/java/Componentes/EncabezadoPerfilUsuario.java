package Componentes;

import Modelo.Usuario;

public class EncabezadoPerfilUsuario extends javax.swing.JPanel {

    public EncabezadoPerfilUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInformacion = new javax.swing.JPanel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_apellido = new javax.swing.JLabel();
        lbl_rol = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imagenPerfil = new Componentes.ImagenPerfil();

        panelInformacion.setLayout(new java.awt.GridLayout(3, 1));

        lbl_nombre.setText("nombre");
        panelInformacion.add(lbl_nombre);

        lbl_apellido.setText("apellido");
        panelInformacion.add(lbl_apellido);

        lbl_rol.setText("rol");
        panelInformacion.add(lbl_rol);

        add(panelInformacion);

        jLabel1.setText("      ");
        add(jLabel1);

        imagenPerfil.setPreferredSize(new java.awt.Dimension(50, 50));
        add(imagenPerfil);
    }// </editor-fold>//GEN-END:initComponents

    public void cargarDatos(Usuario usuario) {
        imagenPerfil.setImage(usuario.getPerfil().getIcon());
        lbl_nombre.setText(usuario.getNombre());
        lbl_apellido.setText(usuario.getApellido());
        lbl_rol.setText(usuario.getRol());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Componentes.ImagenPerfil imagenPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_apellido;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_rol;
    private javax.swing.JPanel panelInformacion;
    // End of variables declaration//GEN-END:variables
}
