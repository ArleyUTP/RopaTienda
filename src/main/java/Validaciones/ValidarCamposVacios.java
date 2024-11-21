package Validaciones;

import javax.swing.JTextField;

public interface ValidarCamposVacios {

    default boolean ValidarCamposVacios(JTextField campo, String nombreCampo) {
        if (campo.getText().isEmpty()) {
            mostrarMensajeError("El campo " + nombreCampo + " no puede estar vacio");
            return true;
        } else {
            return false;
        }
    }

    public abstract void mostrarMensajeError(String mensaje);
}
