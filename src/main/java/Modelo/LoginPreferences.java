package Modelo;

import java.util.prefs.Preferences;

public class LoginPreferences {

    private static final String USUARIO_KEY = "usuario";
    private static final String RECORDAR_USUARIO_KEY = "recordarUsuario";
    private Preferences prefs;
    
    public LoginPreferences() {
        // Se crea el objeto Preferences para guardar la configuración en el sistema
        prefs = Preferences.userNodeForPackage(LoginPreferences.class);
    }
    // Método para guardar el usuario si "Recordar Usuario" está activado
    public void guardarUsuario(String usuario, boolean recordarUsuario) {
        if (recordarUsuario) {
            prefs.put(USUARIO_KEY, usuario);
            prefs.putBoolean(RECORDAR_USUARIO_KEY, true);
        } else {
            prefs.remove(USUARIO_KEY);
            prefs.putBoolean(RECORDAR_USUARIO_KEY, false);
        }
    }
    // Método para obtener el usuario guardado
    public String obtenerUsuarioGuardado() {
        if (prefs.getBoolean(RECORDAR_USUARIO_KEY, false)) {
            return prefs.get(USUARIO_KEY, "");
        }
        return "";
    }
}
