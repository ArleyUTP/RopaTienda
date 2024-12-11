package Modelo;

import java.util.regex.Pattern;

public class NumeroALetraPeru {

    private final String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciséis ",
        "diecisiete ", "dieciocho ", "diecinueve ", "veinte ", "treinta ", "cuarenta ",
        "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
    private final String[] CENTENAS = {"", "ciento ", "doscientos ", "trescientos ", "cuatrocientos ", "quinientos ",
        "seiscientos ", "setecientos ", "ochocientos ", "novecientos "};

    private String moneda = "Soles";
    private String textoDecimal = "/100";

    public NumeroALetraPeru() {
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public void setTextoDecimal(String textoDecimal) {
        this.textoDecimal = textoDecimal;
    }

    public String convertir(String numero, boolean mayusculas) {
        String literal = "";
        String parteDecimal;
        // Reemplazar punto por coma si es necesario
        numero = numero.replace(".", ",");
        // Añadir parte decimal si no está presente
        if (!numero.contains(",")) {
            numero = numero + ",00";
        }
        // Validar formato del número
        if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
            // Dividir número en parte entera y decimal
            String[] partes = numero.split(",");
            parteDecimal = partes[1] + " " + textoDecimal + " " + moneda + ".";
            // Convertir parte entera a letras
            if (Integer.parseInt(partes[0]) == 0) {
                literal = "cero ";
            } else if (Integer.parseInt(partes[0]) > 999999) {
                literal = getMillones(partes[0]);
            } else if (Integer.parseInt(partes[0]) > 999) {
                literal = getMiles(partes[0]);
            } else if (Integer.parseInt(partes[0]) > 99) {
                literal = getCentenas(partes[0]);
            } else if (Integer.parseInt(partes[0]) > 9) {
                literal = getDecenas(partes[0]);
            } else {
                literal = getUnidades(partes[0]);
            }
            // Convertir a mayúsculas si se requiere
            if (mayusculas) {
                return (literal + parteDecimal).toUpperCase();
            } else {
                return (literal + parteDecimal);
            }
        } else {
            return null; // Error en el formato
        }
    }

    private String getUnidades(String numero) {
        String num = numero.substring(numero.length() - 1);
        return UNIDADES[Integer.parseInt(num)];
    }

    private String getDecenas(String num) {
        int n = Integer.parseInt(num);
        if (n < 10) {
            return getUnidades(num);
        } else if (n > 19) {
            String u = getUnidades(num);
            if (u.equals("")) {
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
            } else {
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
            }
        } else {
            return DECENAS[n - 10];
        }
    }

    private String getCentenas(String num) {
        if (Integer.parseInt(num) > 99) {
            if (Integer.parseInt(num) == 100) {
                return "cien ";
            } else {
                return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
            }
        } else {
            return getDecenas(Integer.valueOf(num) + "");
        }
    }

    private String getMiles(String numero) {
        String c = numero.substring(numero.length() - 3);
        String m = numero.substring(0, numero.length() - 3);
        String n = "";
        if (Integer.parseInt(m) > 0) {
            n = getCentenas(m);
            return n + "mil " + getCentenas(c);
        } else {
            return "" + getCentenas(c);
        }
    }

    private String getMillones(String numero) {
        String miles = numero.substring(numero.length() - 6);
        String millon = numero.substring(0, numero.length() - 6);
        String n = "";
        if (millon.length() > 1) {
            n = getCentenas(millon) + "millones ";
        } else {
            n = getUnidades(millon) + "millon ";
        }
        return n + getMiles(miles);
    }
}