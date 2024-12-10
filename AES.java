import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
public class AES {
        public static void main(String[] args) {
            try {
                SecretKey secretKey = generateAESKey();
                String plaintext = "Hello, AES!";
                String ciphertext = encrypt(plaintext, secretKey);
                String decryptedText = decrypt(ciphertext, secretKey);
                System.out.println("Plaintext: " + plaintext);
                System.out.println("Ciphertext: " + ciphertext);
                System.out.println("Decrypted Text: " + decryptedText);
                } 
                catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static SecretKey generateAESKey() throws Exception {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            return keyGenerator.generateKey();
            }
        public static String encrypt(String plaintext, SecretKey secretKey) throws Exception {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
            }
        public static String decrypt(String ciphertext, SecretKey secretKey) throws Exception {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        }
}
