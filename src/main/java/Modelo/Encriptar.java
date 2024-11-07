package Modelo;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Encriptar {

    private static final String SECRET_KEY = "1234567890abcdef"; // Clave secreta de 16 caracteres
    private static final String ALGORITHM = "AES";

    // Método para encriptar la contraseña
    public static String encryptPassword(String password) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encryptedBytes = cipher.doFinal(password.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }

    // Método para desencriptar la contraseña
    public static String decryptPassword(String encryptedPassword) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new RuntimeException("Error al desencriptar la contraseña", e);
        }
    }

    public static boolean matches(String rawPassword, String encryptedPassword) {
        // Intentar desencriptar la contraseña almacenada y compararla con la proporcionada en texto plano
        try {
            String decryptedPassword = decryptPassword(encryptedPassword);
            return rawPassword.equals(decryptedPassword);
        } catch (Exception e) {
            throw new RuntimeException("Error al comparar las contraseñas", e);
        }
    }
}
