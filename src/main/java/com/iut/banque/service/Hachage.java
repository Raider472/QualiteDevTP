package com.iut.banque.service;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hachage {
    public static void main(String[] args) {
        System.out.println(encrypt("clientpass2"));
    }

    public static String encrypt(String password) {
        String key = "JNAJG";
        try{
            Key clef = new SecretKeySpec(key.getBytes("UTF-8"),("Blowfish"));
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, clef);
            byte[] encrypted = cipher.doFinal(password.getBytes("UTF-8"));
            String base64Encoded = Base64.getEncoder().encodeToString(encrypted);

            return base64Encoded.replaceAll("[^a-zA-Z0-9]","");
        } catch (Exception e) {
            return  null;
        }
    }
}
