package Validaciones;

import javax.swing.JTextField;

public interface ValidarCamposNumericos {
    
    default boolean validarDNI(JTextField dni) {
        if (!dni.getText().matches("^[0-9]{8}$")) {  // El DNI debe tener exactamente 8 dígitos
            mostrarMensajeError("El campo DNI debe contener 8 digitos");
            return false;
        }
        return true;
    }

    public abstract void mostrarMensajeError(String mensaje);
}
