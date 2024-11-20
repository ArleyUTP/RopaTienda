package Validaciones;

import javax.swing.JTextField;

public interface ValidarCampoTexto {
    default boolean ValidarCampoTexto(JTextField campo,String mensajeError){
        String regex = "^[a-zA-Z]+(\\s[a-zA-Z]+)*$";
        if (!campo.getText().matches(regex) ){
            mostrarMensajeError(mensajeError);
            return false;
        }
        return true;
    }
    public abstract void mostrarMensajeError(String mensaje);
    default boolean ValidarFormatoTextoConNumero(JTextField campo,String mensajeError){
        String regex = "^[a-zA-Z](?: [a-zA-Z]+)*[0-9]*$";
        if (!campo.getText().matches(regex)) {
            mostrarMensajeError(mensajeError);
            return false;
        }
        return true;
    }
            default boolean validarLongitud(JTextField campo, int min, int max,String mensajeError) {
        if (campo.getText().length() < min || campo.getText().length() > max) {
            mostrarMensajeError(mensajeError);
            return false;
        }else{
            return true;
        }
    }
}
