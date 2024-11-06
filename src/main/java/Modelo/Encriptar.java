package Modelo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String encryptPassword(String password) {
        return encoder.encode(password);
    }

    public boolean matches(String rawPassword, String encryptedPassword) {
        return encoder.matches(rawPassword, encryptedPassword);
    }
}
