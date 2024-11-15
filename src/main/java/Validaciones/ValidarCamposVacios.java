package Validaciones;

import javax.swing.JTextField;

public interface ValidarCamposVacios {

    default boolean ValidarCamposVacios(JTextField campo, String mensajeError) {
        if (campo.getText().isEmpty()) {
            mostrarMensajeError(mensajeError);
            return true;
        } else {
            return false;
        }
    }

    public abstract void mostrarMensajeError(String mensaje);
}
