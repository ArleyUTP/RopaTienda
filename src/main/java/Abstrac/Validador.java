package Abstrac;


import Validaciones.ValidarCamposVacios;
import raven.toast.Notifications;

public abstract class Validador implements ValidarCamposVacios{
    @Override
    public void mostrarMensajeError(String mensaje) {
        Notifications.getInstance().show(Notifications.Type.ERROR,mensaje);
    }
}
