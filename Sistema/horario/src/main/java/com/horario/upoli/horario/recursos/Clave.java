package com.horario.upoli.horario.recursos;

public class Clave {
    /*ejemplo*/
    /*PasswordGenerator.getPassword(
		PasswordGenerator.MINUSCULAS+
		PasswordGenerator.MAYUSCULAS+
		PasswordGenerator.ESPECIALES,10);*/
    public static String NUMEROS = "0123456789";

    public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

    public static String ESPECIALES = "ñÑ";

    public static String getPinNumber() {
        return getClave(NUMEROS, 4);
    }

    public static String getClave() {
        return getClave(8);
    }

    public static String getClave(int length) {
        return getClave(NUMEROS + MAYUSCULAS + MINUSCULAS, length);
    }

    public static String getClave(String serial, int length) {
        String pswd = "";

        for (int i = 0; i < length; i++) {
            pswd+=(serial.charAt((int)(Math.random() * serial.length())));
        }

        return pswd;
    }
}
