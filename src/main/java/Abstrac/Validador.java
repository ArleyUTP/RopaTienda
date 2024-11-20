package Abstrac;


import Validaciones.ValidarCampoTexto;
import Validaciones.ValidarCamposNumericos;
import Validaciones.ValidarCamposVacios;
import Validaciones.ValidarImagen;
import raven.toast.Notifications;

public abstract class Validador implements ValidarCamposVacios,ValidarCampoTexto,ValidarCamposNumericos,ValidarImagen{
    @Override
    public void mostrarMensajeError(String mensaje) {
        Notifications.getInstance().show(Notifications.Type.ERROR,mensaje);
    }
}
