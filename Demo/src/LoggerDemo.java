import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerDemo {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		System.out.println("Logger info-->\t"+Logger.getLogger("myLogger")+"\t"+Logger.GLOBAL_LOGGER_NAME);
		LogManager manager=LogManager.getLogManager();
		Logger log=manager.getLogger(Logger.GLOBAL_LOGGER_NAME);
		log.log(Level.INFO,"first log created");
		try {
		KeyPairGenerator kpg=KeyPairGenerator.getInstance("DSA");
		kpg.initialize(1024);
		KeyPair peyPair=kpg.genKeyPair();
		PrivateKey pk=peyPair.getPrivate();
		
		byte[] keyByte=pk.getEncoded();
		EncodedKeySpec eks=new PKCS8EncodedKeySpec(keyByte);
		
		KeyFactory kf=KeyFactory.getInstance("DSA");
		PrivateKey privateKey=kf.generatePrivate(eks);
		
		System.out.println("privateKey-->\t"+privateKey);
		
		
		
	}
		catch(NoSuchAlgorithmException ae)
		
		{
			System.out.println("exception"+ae);
		}
		catch(InvalidKeySpecException ie)
		
		{
			System.out.println("exception"+ie);
		}

	}
	
}
