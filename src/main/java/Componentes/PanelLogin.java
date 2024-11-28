/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Componentes;

import Modelo.Usuario;
import Persistencia.LoginDAO;
import Persistencia.UsuarioDAO;
import Vista.Menu_Principal;
//import Vista.Vista_EnvioCorreo;
import Vista_Usuarios.Crear;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;

public class PanelLogin extends javax.swing.JPanel {

    public PanelLogin() {
        initComponents();
        init();
        btn_crearCuenta.setVisible(false);
        configurarAutoCompleter();
        lbl_ocultarContraseña.setVisible(false);
    }

    private void init() {
        txt_usuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Usuario");
        txt_usuario.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;" // Bordes redondeados
                + "borderWidth:1;" // Borde del campo
                + "borderColor:#E0E0E0;" // Color gris suave para el borde
                + "focusWidth:2;" // Ancho del borde al enfocar
                + "focusColor:#39E079;" // Verde esmeralda al enfocar
                + "margin:5,20,5,20;" // Margen interno
                + "background:$TextField.background;");

        txt_clave.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Contraseña");
        txt_clave.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;" // Bordes redondeados
                + "borderWidth:1;" // Borde del campo
                + "borderColor:#E0E0E0;" // Gris suave
                + "focusWidth:2;" // Ancho de borde al enfocar
                + "focusColor:#39E079;" // Verde esmeralda al enfocar
                + "margin:5,20,5,20;" // Margen interno
                + "background:$TextField.background;");

        btn_ingresar.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;" // Bordes redondeados
                + "borderWidth:0;" // Sin borde
                + "focusWidth:0;" // Sin borde de enfoque
                + "margin:5,20,5,20;" // Margen interno
                + "background:#39E079;" // Fondo esmeralda
                + "foreground:#FFFFFF;");  // Texto blanco

        btn_crearCuenta.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;" // Bordes redondeados
                + "borderWidth:1;" // Borde fino
                + "borderColor:#E0E0E0;" // Gris claro
                + "focusWidth:0;" // Sin borde de enfoque
                + "margin:5,20,5,20;" // Margen interno
                + "background:#39E079;" // Fondo gris claro
                + "foreground:#FFFFFF;");  // Texto blanco

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_usuario = new javax.swing.JTextField();
        txt_clave = new javax.swing.JPasswordField();
        chk_recordarUsuario = new javax.swing.JCheckBox();
        btn_ingresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_crearCuenta = new javax.swing.JButton();
        lbl_verContraseña = new javax.swing.JLabel();
        lbl_ocultarContraseña = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(312, 434));

        txt_usuario.setToolTipText("Usuario");
        txt_usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usuarioFocusLost(evt);
            }
        });
        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyReleased(evt);
            }
        });

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

        chk_recordarUsuario.setText("Recordar Usuario");
        chk_recordarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_recordarUsuarioActionPerformed(evt);
            }
        });

        btn_ingresar.setText("Ingresar");
        btn_ingresar.putClientProperty("JButton.buttonType", "roundRect");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });

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

        lbl_verContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/eye.png"))); // NOI18N
        lbl_verContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_verContraseñaMouseClicked(evt);
            }
        });

        lbl_ocultarContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/eye-slash.png"))); // NOI18N
        lbl_ocultarContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ocultarContraseñaMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BIENVENIDO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chk_recordarUsuario)
                            .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_crearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel4))
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_verContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ocultarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_ocultarContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_verContraseña)))
                .addGap(30, 30, 30)
                .addComponent(chk_recordarUsuario)
                .addGap(30, 30, 30)
                .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(btn_crearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioFocusLost
        reactivarCuenta();
    }//GEN-LAST:event_txt_usuarioFocusLost

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuarioActionPerformed

    private void txt_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyReleased

        verificarAccesoAdministrador();
        existeUsuarioRecordado();
    }//GEN-LAST:event_txt_usuarioKeyReleased

    private void txt_claveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_claveFocusLost
        //        verificarAccesoAdministrador();
    }//GEN-LAST:event_txt_claveFocusLost

    private void txt_claveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_claveKeyReleased
        verificarAccesoAdministrador();
    }//GEN-LAST:event_txt_claveKeyReleased

    private void chk_recordarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_recordarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_recordarUsuarioActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        LoginDAO loginDAO = new LoginDAO();
        if (loginDAO.validarIngreso(txt_usuario)) {
            validar();
            recordarUsuario();
            desactivarRecordarUsuario();
        }
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
//        // TODO add your handling code here:
//        Vista_EnvioCorreo vista_EnvioCorreo = new Vista_EnvioCorreo();
//        vista_EnvioCorreo.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btn_crearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearCuentaActionPerformed
        Dimension originalSize = this.getSize();
        this.setSize(this.getWidth(), 600); // Asegúrate de que el tamaño sea suficiente para mostrar el Popup
        Vista_Usuarios.Crear crear = new Crear();
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Cancelar", "Guardar"};
        GlassPanePopup.showPopup(
                new SimplePopupBorder(crear, "Crear Usuario", actions, (pc, i) -> {
                    if (i == 1) {
                        // Lógica para crear el usuario
                        Usuario usuario = crear.crearUsuario();
                        System.out.println("Usuario devuelto del Popup: " + usuario.toString());
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        try {
                            usuarioDAO.crearUsuario(usuario);
                        } catch (IOException ex) {
                        }
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Usuario creado correctamente");
                    } else {
                        pc.closePopup();
                    }
                    // Restauramos el tamaño original del JFrame después de interactuar con el Popup
                    this.setSize(originalSize);
                }),
                option
        );
    }//GEN-LAST:event_btn_crearCuentaActionPerformed

    private void lbl_verContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_verContraseñaMouseClicked
        txt_clave.setEchoChar((char) 0);
        lbl_verContraseña.setVisible(false);
        lbl_ocultarContraseña.setVisible(true);
    }//GEN-LAST:event_lbl_verContraseñaMouseClicked

    private void lbl_ocultarContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ocultarContraseñaMouseClicked
        // TODO add your handling code here:
        txt_clave.setEchoChar('\u2022');
        lbl_ocultarContraseña.setVisible(false);
        lbl_verContraseña.setVisible(true);
    }//GEN-LAST:event_lbl_ocultarContraseñaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_crearCuenta;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JCheckBox chk_recordarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_ocultarContraseña;
    private javax.swing.JLabel lbl_verContraseña;
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
    private int intentos = 0;

    private void validar() {
        String usuario = txt_usuario.getText();
        String clave = new String(txt_clave.getPassword());
        LoginDAO loginDAO = new LoginDAO();

        if (clave.isEmpty()) {
            loginDAO.mostrarMensajeError("El campo clave no puede estar vacío");
            return;
        }

        Usuario usuarioAutenticado = loginDAO.validarCredenciales(usuario, clave);

        if (usuarioAutenticado != null) {
            intentos = 0;
            Menu_Principal menu = new Menu_Principal(usuarioAutenticado);
            menu.setVisible(true);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Credenciales correctas");
        } else {
            intentos++;
            if (intentos == 3) {
                String mensaje = loginDAO.desactivarCuenta(usuario);
                JOptionPane.showMessageDialog(null, mensaje, "Cuenta bloqueada", JOptionPane.ERROR_MESSAGE);
                intentos = 0;
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Credenciales incorrectas");
            }
        }
    }

    private void recordarUsuario() {
        LoginDAO loginDAO = new LoginDAO();
        String usuario = txt_usuario.getText();
        String clave = new String(txt_clave.getPassword());
        Usuario usuarioAutenticado = loginDAO.validarCredenciales(usuario, clave);

        if (usuarioAutenticado != null && chk_recordarUsuario.isSelected()) {
            List<Usuario> usuariosRecord = loginDAO.obtenerUsuariosRecordados();

            boolean usuarioYaRecordado = usuariosRecord.stream()
                    .anyMatch(usu -> usuario.equals(usu.getUsuario()));
            if (!usuarioYaRecordado) {
                loginDAO.agregarUsuarioRecordado(usuario);
            }
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

    private void reactivarCuenta() {
        String usuario = txt_usuario.getText();
        LoginDAO loginDAO = new LoginDAO();
        loginDAO.reactivarCuenta(usuario);
    }
}
