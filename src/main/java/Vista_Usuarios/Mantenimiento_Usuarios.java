package Vista_Usuarios;

import Modelo.Usuario;
import Persistencia.UsuarioDAO;
import Vista_Usuarios.table.CheckBoxTableHeaderRenderer;
import Vista_Usuarios.table.ProfileTableRenderer;
import Vista_Usuarios.table.TableHeaderAlignment;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;

public class Mantenimiento_Usuarios extends javax.swing.JFrame {

    public Mantenimiento_Usuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        init();
        cargarDatosTabla();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setMaximizedBounds(this.getGraphicsConfiguration().getBounds());
    }

    private void init() {
        GlassPanePopup.install(this);
        Notifications.getInstance().setJFrame(this);
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        table.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:70;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");
        lbl_titulo.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");
        txt_busqueda.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Busqueda...");
        txt_busqueda.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("sample/icon/search.svg"));
        txt_busqueda.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");
        table.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(table, 0));
        table.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(table));
        table.getColumnModel().getColumn(2).setCellRenderer(new ProfileTableRenderer(table));
        testData();
    }

    private void testData() {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_titulo = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        btn_eliminar = new Vista_Usuarios.table.ButtonAction();
        btn_editar = new Vista_Usuarios.table.ButtonAction();
        btn_crear = new Vista_Usuarios.table.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SELECT", "#", "Nombre", "Apellido", "DNI", "Correo", "Usuario", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(40);
            table.getColumnModel().getColumn(1).setMaxWidth(40);
            table.getColumnModel().getColumn(2).setPreferredWidth(200);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        lbl_titulo.setText("Usuarios");

        btn_eliminar.setText("Eliminar");

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_crear.setText("Crear");
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_titulo)
                            .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 42, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
// TODO add your handling code here:
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
                        Usuario usuario = crear.crearUsuario();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        usuarioDAO.crearUsuario(usuario);
                        pc.closePopup();
                        cargarDatosTabla();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Usuario creado Correctamente");
                    } else {
                        pc.closePopup();
                    }
                }),
                option
        );
    }//GEN-LAST:event_btn_crearActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // Lista para almacenar los usuarios seleccionados en la tabla
        List<Usuario> selectedUsers = getSelectedUsers();
        // Verificar si hay algún usuario seleccionado
        if (!selectedUsers.isEmpty()) {
            if (selectedUsers.size() == 1) {
                Usuario usuario = selectedUsers.get(0);
                Crear crear = new Crear();
                crear.cargarDatos(usuario);
                String[] actions = new String[]{"Cancelar", "Actualizar"};
                GlassPanePopup.showPopup(
                        new SimplePopupBorder(crear, "Editar Usuario [" + usuario.getNombre() + "]", actions, (popupComponent, i) -> {
                            if (i == 1) { // Opción de "Actualizar"
                                Usuario usuarioEditado = crear.obtenerDatos();
                                UsuarioDAO usuarioDAO = new UsuarioDAO();
                                usuarioDAO.actualizarUsuario(usuarioEditado);
                                popupComponent.closePopup();
                                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Usuario actualizado exitosamente");
                                cargarDatosTabla();
                            } else {
                                popupComponent.closePopup(); // Cerrar el popup sin hacer nada
                            }
                        })
                );
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Seleccionar solo un Usuario para Editar");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Selecciona un usuario para editar");
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    public static void main(String args[]) {
        FlatRobotoFont.install();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mantenimiento_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista_Usuarios.table.ButtonAction btn_crear;
    private Vista_Usuarios.table.ButtonAction btn_editar;
    private Vista_Usuarios.table.ButtonAction btn_eliminar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables

    private List<Usuario> getSelectedUsers() throws NullPointerException {
        List<Usuario> selectedUsers = new ArrayList<>();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        for (int i = 0; i < table.getRowCount(); i++) {
            Boolean isSelected = (Boolean) table.getValueAt(i, 0); // Columna de selección
            if (isSelected != null && isSelected) {
                int userId = (Integer) table.getValueAt(i, 1); // Columna de ID o #
                Usuario usuario = usuarioDAO.obtenerUsuarioPorId(userId); // Obtener el usuario de la base de datos
                selectedUsers.add(usuario);
            }
        }
        return selectedUsers;
    }

    private void cargarDatosTabla() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);  // Borra todas las filas actuales
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<Usuario> usuarios = usuarioDAO.obtenerTodosLosUsuarios();
            for (Usuario usuario : usuarios) {
                Object[] fila = new Object[]{
                    false, // Columna de selección (Checkbox)
                    usuario.getIdUsuario(), // ID del usuario
                    usuario,
                    usuario.getApellido(), // Apellido
                    usuario.getDni(), // DNI
                    usuario.getCorreo(), // Correo
                    usuario.getUsuario(), // Nombre de usuario
                    usuario.getRol()};
                model.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos en la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
