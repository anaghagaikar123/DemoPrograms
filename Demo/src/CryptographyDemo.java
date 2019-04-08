import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptographyDemo {

	private static final String key="aesEncryptionKey";
	private static final String  initVector="encryptionIntVec";
	public static void main(String[] args) {
		
		String str="anagha";
		System.out.println("gvn str-->\t"+str);
		String encrypted=encryptString(str);
		System.out.println("encrypted-->\t"+encrypted);
		String decrypted=decryptedString(encrypted);
		System.out.println("decrypted-->\t"+decrypted);

	}

	private static String decryptedString(String encrypted) {
		try
		{
			IvParameterSpec iv=new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec sks=new SecretKeySpec(key.getBytes(),"AES");
			Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE,sks,iv);
			return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
			 
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception occured"+ex);
		}
		return null;
	
	}

	private static String encryptString(String str) {
		try
		{
			IvParameterSpec iv=new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec sks=new SecretKeySpec(key.getBytes(),"AES");
			Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE,sks,iv);
			byte[] encrypted=cipher.doFinal(str.getBytes());
			 return Base64.getEncoder().encodeToString(encrypted);
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception occured"+ex);
		}
		return null;
	}

}
