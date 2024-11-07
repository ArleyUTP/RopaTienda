package Vista;

import Modelo.Usuario;
import Persistencia.LoginDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class Vista_login extends javax.swing.JFrame {

    public Vista_login() {
        initComponents();
        btn_crearCuenta.setVisible(false);
        configurarAutoCompleter();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_ingresar = new javax.swing.JButton();
        chk_recordarUsuario = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        btn_crearCuenta = new javax.swing.JButton();
        txt_clave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BIENVENIDO");

        jLabel2.setText("Usuario");

        txt_usuario.putClientProperty("JTextField.placeholderText", "Ingrese su usuario");
        txt_usuario.putClientProperty( "JComponent.roundRect" , true );
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyReleased(evt);
            }
        });

        jLabel3.setText("Clave");

        btn_ingresar.setText("Ingresar");
        btn_ingresar.putClientProperty("JButton.buttonType", "roundRect");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });

        chk_recordarUsuario.setText("Recordar Usuario");

        jLabel4.setText("¿Olvido su contraseña?");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        btn_crearCuenta.setText("Crear Nueva Cuenta");
        btn_crearCuenta.putClientProperty("JButton.buttonType", "roundRect");
        btn_crearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearCuentaActionPerformed(evt);
            }
        });

        txt_clave.putClientProperty("JComponent.roundRect", true);
        txt_clave.putClientProperty("JTextField.placeholderText", "Ingrese su contraseña");
        txt_clave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_claveFocusLost(evt);
            }
        });
        txt_clave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_claveKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(chk_recordarUsuario))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btn_crearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(chk_recordarUsuario)
                .addGap(0, 0, 0)
                .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(14, 14, 14)
                .addComponent(btn_crearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        validar();
        recordarUsuario();
        desactivarRecordarUsuario();
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void txt_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyReleased

        verificarAccesoAdministrador();
        existeUsuarioRecordado();
    }//GEN-LAST:event_txt_usuarioKeyReleased

    private void txt_claveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_claveKeyReleased
        verificarAccesoAdministrador();
    }//GEN-LAST:event_txt_claveKeyReleased

    private void btn_crearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_crearCuentaActionPerformed

    private void txt_claveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_claveFocusLost
//        verificarAccesoAdministrador();
    }//GEN-LAST:event_txt_claveFocusLost

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Vista_EnvioCorreo vista_EnvioCorreo = new Vista_EnvioCorreo();
        vista_EnvioCorreo.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_crearCuenta;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JCheckBox chk_recordarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JPasswordField txt_clave;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
    private void verificarAccesoAdministrador() {
        LoginDAO loginDAO = new LoginDAO();
        String usuario = txt_usuario.getText(); // Eliminamos espacios en blanco
        String clave = new String(txt_clave.getPassword());

        if (usuario.isEmpty() || clave.isEmpty()) {
            return;
        }
        new Thread(() -> {
            boolean esAdmin = loginDAO.esUsuarioAdmin(usuario, clave);
            SwingUtilities.invokeLater(() -> {
                btn_crearCuenta.setVisible(esAdmin);
            });
        }).start();
    }

    private void validar() {
        LoginDAO loginDAO = new LoginDAO();
        String usuario = txt_usuario.getText();
        String clave = new String(txt_clave.getPassword());
        Usuario usuarioAutenticado = loginDAO.validarCredenciales(usuario, clave);
        if (usuarioAutenticado != null) {
            //Ir a la ventana principal y pasar el parametro usuario para mostrar el usuario actual en la aplicacion
            //Cerrar la ventana actual
            this.dispose();
        }
    }

    private void recordarUsuario() {
        LoginDAO loginDAO = new LoginDAO();
        String usuario = txt_usuario.getText();
        String clave = new String(txt_clave.getPassword());
        Usuario usuarioAutenticado = loginDAO.validarCredenciales(usuario, clave);
        if (usuarioAutenticado != null && chk_recordarUsuario.isSelected()) {
            loginDAO.agregarUsuarioRecordado(usuario);
        }
    }

    private void desactivarRecordarUsuario() {
        LoginDAO loginDAO = new LoginDAO();
        String usuario = txt_usuario.getText();
        String clave = new String(txt_clave.getPassword());
        Usuario usuarioAutenticado = loginDAO.validarCredenciales(usuario, clave);
        if (usuarioAutenticado != null && !chk_recordarUsuario.isSelected()) {
            loginDAO.eliminarUsuarioRecordado(usuario);
        }
    }

    private void existeUsuarioRecordado() {
    String usuarioIngresado = txt_usuario.getText();
    LoginDAO loginDAO = new LoginDAO();
    List<Usuario> usuariosRecord = loginDAO.obtenerUsuariosRecordados();
    boolean existe = usuariosRecord.stream()
            .anyMatch(usuario -> usuario.getUsuario().equals(usuarioIngresado));
    chk_recordarUsuario.setSelected(existe);
}
    private void configurarAutoCompleter() {
        LoginDAO loginDAO = new LoginDAO();
        List<Usuario> usuariosRecord = loginDAO.obtenerUsuariosRecordados();
        List<String> usuariosRecordados = new ArrayList<>();
        usuariosRecord.forEach(usuario -> {
            String nombreUsuario = usuario.getUsuario();
            usuariosRecordados.add(nombreUsuario);
        });
        AutoCompleteDecorator.decorate(txt_usuario, usuariosRecordados, false);
    }
}
