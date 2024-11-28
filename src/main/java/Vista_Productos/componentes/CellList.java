package Vista_Productos.componentes;

import Modelo.Perfil;
import java.util.List;
import javax.swing.DefaultListModel;

public class CellList extends javax.swing.JPanel {

    private List<Perfil> imagenes;

    public CellList(List<Perfil> perfiles) {
        this.imagenes = perfiles;
        initComponents();
        cargarDatos();
    }

    private void cargarDatos() {
        DefaultListModel<Perfil> modelo = new DefaultListModel<>();
        if (imagenes != null) {
            imagenes.forEach(perfils -> modelo.addElement(perfils));
            listaDeImagenes.setModel(modelo);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaDeImagenes = new javax.swing.JList<Perfil>();

        jScrollPane1.setViewportView(listaDeImagenes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Perfil> listaDeImagenes;
    // End of variables declaration//GEN-END:variables
}
