/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Andres
 */
public class Cifrador {

    private static String clave = "1234567890ABCDEF";

    public static byte[] encrypt(String message) throws Exception {
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] digestOfPassword = md.digest(clave.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }
        SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] plainTextBytes = message.getBytes("utf-8");
        byte[] cipherText = cipher.doFinal(plainTextBytes);
        return cipherText;
    }

    public static String decrypt(byte[] message) throws Exception {
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] digestOfPassword = md.digest(clave.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }
        SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        decipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = decipher.doFinal(message);
        return new String(plainText, "UTF-8");
    }
    
    public static void main(String[] args) throws Exception {
        String text = "I am sunil";
        byte[] codedtext = Cifrador.encrypt(text);
        String decodedtext = Cifrador.decrypt(codedtext);
        for (int i = 0; i < codedtext.length; i++) {
            if (codedtext[i] + 128 < 16) {
                System.out.print("0" + Integer.toHexString(codedtext[i] + 128));
            } else {
                System.out.print(Integer.toHexString(codedtext[i] + 128));
            }
        }
        System.out.println();
        System.out.println(decodedtext);
    }

}