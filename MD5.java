import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5{
    private static String md5(String input){
        try{
            MessageDigest md5Digest=MessageDigest.getInstance("MD5");
            byte[] inputBytes=input.getBytes();
            byte[] digestBytes=md5Digest.digest(inputBytes);

            StringBuilder sb=new StringBuilder();
            for(byte b : digestBytes){
                sb.append(String.format("%02x",b));
            }
            return sb.toString();
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();;
        }
        return null;
    }    
    public static void main(String[] args){
        String input="Hello, World!";
        String md5Hash=md5(input);
        System.out.println("MD5 Hash:"+md5Hash);
    }
}
