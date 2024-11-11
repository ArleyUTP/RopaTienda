package Vista_Usuarios;

import Modelo.Usuario;
import Vista_Usuarios.table.SuperEllipse2D;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Shape;
import javaswingdev.picturebox.DefaultPictureBoxRender;
import javax.swing.ImageIcon;

public class TableCellProfile extends javax.swing.JPanel {

    public TableCellProfile(Usuario usuario, Font font) {
        initComponents();
        lbl_nombre.setFont(font);
        lbl_estado.setFont(font);
        lbl_nombre.setText(usuario.getNombre());
        lbl_estado.setText(usuario.getEstado());
        lbl_estado.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Label.disabledForeground");
        if (usuario.getFoto() != null && !usuario.getFoto().isEmpty()) {
            perfil.setImage(new ImageIcon(usuario.getFoto()));
        }
        perfil.setPictureBoxRender(new DefaultPictureBoxRender() {
            @Override
            public Shape render(Rectangle rec) {
                return new SuperEllipse2D(rec.x, rec.y, rec.width, rec.height, 3f).getShape();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nombre = new javax.swing.JLabel();
        lbl_estado = new javax.swing.JLabel();
        perfil = new javaswingdev.picturebox.PictureBox();

        lbl_nombre.setText("Nombre");

        lbl_estado.setText("Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nombre)
                    .addComponent(lbl_estado))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_estado)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_nombre;
    private javaswingdev.picturebox.PictureBox perfil;
    // End of variables declaration//GEN-END:variables

    public void setValue(Usuario usuario) {
        lbl_nombre.setText(usuario.getNombre());
        lbl_estado.setText(usuario.getEstado());
        perfil.setImage(usuario.getProfile().getIcon());
    }
}
