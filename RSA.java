import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class RSA {

    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private int bitlength = 1024;
    private Random r;

    public RSA() {
        r = new SecureRandom();
        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlength / 2, r);

        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, N);
    }

    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(d, N);
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();

        BigInteger message = new BigInteger("42"); // Example message

        BigInteger encrypted_msg = rsa.encrypt(message);
        BigInteger decrypted_msg = rsa.decrypt(encrypted_msg);

        System.out.println("Message: " + message);
        System.out.println("Encrypted Message: " + encrypted_msg);
        System.out.println("Decrypted Message: " + decrypted_msg);
    }
}
