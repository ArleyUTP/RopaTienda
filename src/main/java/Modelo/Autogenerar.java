package Modelo;

import Abstrac.DAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import org.passay.*;

public class Autogenerar extends DAO {

    public String generarUsuario(String nombre, String Apellido, String dni) {
        String usuarioGenerado = "";
        try (Connection con = getconection(); CallableStatement cs = con.prepareCall("EXEC GenerarUsuarioUnico ?,?,?,?")) {
            cs.setString(1, nombre);
            cs.setString(2, Apellido);
            cs.setString(3, dni);
            //Parametro a Recibir
            cs.registerOutParameter(4, java.sql.Types.NVARCHAR);
            cs.execute();
            usuarioGenerado = cs.getString(4);
        } catch (Exception e) {
            manejarError("Error al generar usuario unico", e);
        }
        return usuarioGenerado;
    }

    public String generarClave() {
        PasswordGenerator generator = new PasswordGenerator();
        CharacterRule lowerCaseRule = new CharacterRule(EnglishCharacterData.LowerCase, 1);
        CharacterRule upperCaseRule = new CharacterRule(EnglishCharacterData.UpperCase, 1);
        CharacterRule digitRule = new CharacterRule(EnglishCharacterData.Digit, 1);
        CharacterRule specialCharRule = new CharacterRule(EnglishCharacterData.Special, 1);
        return generator.generatePassword(8, lowerCaseRule, upperCaseRule, digitRule, specialCharRule);
    }
    
}
