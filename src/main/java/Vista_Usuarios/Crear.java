package Vista_Usuarios;

import Modelo.Autogenerar;
import Modelo.Encriptar;
import Modelo.Usuario;
import java.sql.Date;

public class Crear extends javax.swing.JPanel {

    public Crear() {
        initComponents();
        datePicker.setCloseAfterSelected(true);
        datePicker.setEditor(txt_fechaNacimiento);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker = new raven.datetime.component.date.DatePicker();
        grupoEstado = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_dni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_fechaNacimiento = new javax.swing.JFormattedTextField();
        txt_clave = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbo_rol = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_activo = new javax.swing.JRadioButton();
        btn_inactivo = new javax.swing.JRadioButton();

        jLabel1.setText("Nombre");

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombreKeyReleased(evt);
            }
        });

        jLabel3.setText("Apellido");

        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyReleased(evt);
            }
        });

        jLabel4.setText("F.Nacimiento");

        txt_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dniKeyReleased(evt);
            }
        });

        jLabel5.setText("DNI");

        jLabel7.setText("Usuario");

        jLabel8.setText("Correo");

        jLabel9.setText("Rol");

        jLabel10.setText("Clave");

        cbo_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Vendedor" }));
        cbo_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_rolActionPerformed(evt);
            }
        });

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Estado");

        grupoEstado.add(btn_activo);
        btn_activo.setText("Activo");

        grupoEstado.add(btn_inactivo);
        btn_inactivo.setText("Inactivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_fechaNacimiento)
                            .addComponent(cbo_rol, 0, 187, Short.MAX_VALUE)
                            .addComponent(txt_dni)
                            .addComponent(txt_apellido)
                            .addComponent(txt_nombre)
                            .addComponent(txt_correo)
                            .addComponent(txt_usuario)
                            .addComponent(txt_clave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_activo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_inactivo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cbo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_activo)
                        .addComponent(btn_inactivo)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_rolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_rolActionPerformed

    private void txt_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyReleased

        generarUsuario();
    }//GEN-LAST:event_txt_nombreKeyReleased

    private void txt_apellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyReleased
        // TODO add your handling code here:
        generarUsuario();
    }//GEN-LAST:event_txt_apellidoKeyReleased

    private void txt_dniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyReleased
        // TODO add your handling code here:
        generarUsuario();
    }//GEN-LAST:event_txt_dniKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txt_clave.getText().isEmpty()) {
            Autogenerar autogenerar = new Autogenerar();
            txt_clave.setText(autogenerar.generarClave());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btn_activo;
    private javax.swing.JRadioButton btn_inactivo;
    private javax.swing.JComboBox<String> cbo_rol;
    private raven.datetime.component.date.DatePicker datePicker;
    private javax.swing.ButtonGroup grupoEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_clave;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JFormattedTextField txt_fechaNacimiento;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    private void generarUsuario() {
        String nombre = txt_nombre.getText();
        String apellido = txt_apellido.getText();
        String dni = txt_dni.getText();
        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
            return;
        }
        Autogenerar autogenerar = new Autogenerar();
        String usuarioGenerado = autogenerar.generarUsuario(nombre, apellido, dni);
        txt_usuario.setText(usuarioGenerado);
    }
    public Usuario datos(){
        Usuario usuario = null;
        String nombre = txt_nombre.getText();
        String apellido = txt_apellido.getText();
        String dni = txt_dni.getText();
        Date fechaNacimiento = datePicker.isDateSelected() ? Date.valueOf(datePicker.getSelectedDate()) : null;
        String correo = txt_correo.getText();
        String usuarioString = txt_usuario.getText();
        String contraseña = txt_clave.getText();
        //Encriptar 
        Encriptar encriptar = new Encriptar();
        String contraseñaEncriptada = encriptar.encryptPassword(contraseña);
        String rol = cbo_rol.getSelectedItem().toString().toLowerCase();
        String estado = null;
        if (btn_activo.isSelected()) estado = "activo";
        if (btn_inactivo.isSelected()) estado = "inactivo";
        if (nombre.isEmpty() ) {
            
        }
        return usuario;
    }
}
