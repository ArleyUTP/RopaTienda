package Vista_Productos.componentes;

import Modelo.Perfil;
import java.util.List;
import javax.swing.DefaultListModel;

public class CellList extends javax.swing.JPanel {

    private List<Perfil> imagenes;

    public CellList(List<Perfil> perfiles) {
        initComponents();
        listaDeImagenes.setCellRenderer(new ImageListRenderer(listaDeImagenes));
        cargarDatos(perfiles);
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.imagenes = perfiles; // Actualizar la lista
    }

    private void cargarDatos(List<Perfil> perfiles) {
        DefaultListModel<Perfil> modelo = new DefaultListModel<>();
        if (perfiles != null && !perfiles.isEmpty()) {
            perfiles.forEach(modelo::addElement);
        } else {
            modelo.addElement(new Perfil("Lista vacía", null)); // Mensaje cuando no hay datos
        }
        listaDeImagenes.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        listaDeImagenes = new javax.swing.JList<Perfil>();

        jPanel1.setLayout(new java.awt.BorderLayout());

        listaDeImagenes.setPreferredSize(new java.awt.Dimension(200, 300));
        jPanel1.add(listaDeImagenes, java.awt.BorderLayout.CENTER);

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Perfil> listaDeImagenes;
    // End of variables declaration//GEN-END:variables
}
