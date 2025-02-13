import java.math.BigInteger;
import java.security.SecureRandom;
public class DiffieHellman {
  public static void main(String[] args) {
    BigInteger p = generatePrimeNumber();
    BigInteger g = generatePrimitiveRoot(p);
    BigInteger a = generatePrivateKey();
    BigInteger b = generatePrivateKey();
    BigInteger A = g.modPow(a, p);
    BigInteger B = g.modPow(b, p);
    BigInteger secretKeyA = B.modPow(a, p);
    BigInteger secretKeyB = A.modPow(b, p);
    if (secretKeyA.equals(secretKeyB)) {
    System.out.println(&quot;Shared secret key: &quot; + secretKeyA);
    } 
    else {
    System.out.println(&quot;Error: Shared secret keys do not match.&quot;);
    }
  }
private static BigInteger generatePrimeNumber() {
  return BigInteger.probablePrime(512, new SecureRandom());
}
private static BigInteger generatePrimitiveRoot(BigInteger p) {
  BigInteger g = BigInteger.valueOf(2);
  while (g.compareTo(p.subtract(BigInteger.ONE)) &lt; 0) {
  if (!g.modPow(BigInteger.valueOf(2), p).equals(BigInteger.ONE) &amp;&amp;
!g.modPow(p.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2)),p).equals(BigInteger.ONE)) {
return g;
}
g = g.add(BigInteger.ONE);
}
return null;
}
private static BigInteger generatePrivateKey() {
  BigInteger maxRange = BigInteger.TEN.pow(10);
  SecureRandom random = new SecureRandom();
  return new BigInteger(maxRange.bitLength(), random).mod(maxRange);
}
}
