package Validaciones;

import javax.swing.JTextField;

public interface ValidarCamposVacios {

    default boolean ValidarCamposVacios(JTextField campo, String mensajeError) {
        String regex = "^\\s*\\S+\\s*$";
        if (campo.getText().matches(regex)) {
            return true;
        } else {
            mostrarMensajeError(mensajeError);
            return false;
        }
    }
    public abstract void mostrarMensajeError(String mensaje);
}
