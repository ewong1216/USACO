package encryptionCracker;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// --------------------------------------------------------
// NOTE!!!!  Look at RUNNER.JAVA first
//
// Create an instance of AESCipher by passing to the constructor your prime (p), shared base (g),
// and your two secret values (a and b).  Then, call decrypt on a byte array to turn it
// back into the original clear-text String (or call encrypt to turn a clear-text String
// into a byte array).
//--------------------------------------------------------

public class AESCipher 
{
	// We always use the same initialization vector, to simplify decrypting messages encrypted
	// from another instance of AESCipher
	private static final IvParameterSpec IV = new  IvParameterSpec(new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
	
	private Cipher encryptionCipher;
	private Cipher decryptionCipher;

	// You construct an AESCipher with the prime p, shared g, and the secrets a and b chosen
	// by Alice and Bob
	public AESCipher(long p, long g, long a, long b)
	{
		// Params -> BigIntegers
		BigInteger pBig = BigInteger.valueOf(p);
		BigInteger gBig = BigInteger.valueOf(g);
		BigInteger aBig = BigInteger.valueOf(a);
		BigInteger bBig = BigInteger.valueOf(b);

		// Calculate key, put it into a keySpec
		BigInteger key = gBig.modPow(aBig.multiply(bBig), pBig);
		ByteBuffer buffer = ByteBuffer.allocate(16);
		buffer.putLong(key.longValue());
		SecretKeySpec keySpec = new SecretKeySpec(buffer.array(), "AES");

		// Create and initialize the underlying ciphers
		try
		{
			encryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
			encryptionCipher.init(Cipher.ENCRYPT_MODE, keySpec, IV);

			decryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
			decryptionCipher.init(Cipher.DECRYPT_MODE, keySpec, IV);
		}
		catch (Exception e)
		{
			System.err.println("ERROR!  AESCipher constructor threw exception: " + e);
		}
	}

	// Given a clear-text message, encrypt it into an array of bytes.
	public byte[] encrypt(String message)
	{
		try
		{
			return encryptionCipher.doFinal(message.getBytes("UTF-8"));
		}
		catch (Exception e)
		{
			System.err.println("ERROR!  encrypt threw exception: " + e);
			return null;
		}
	}

	// Given an encrypted array of bytes, decrypt it back to the original
	// clear-text message
	public String decrypt(byte[] bytes)
	{
		try
		{
			return new String(decryptionCipher.doFinal(bytes));
		}
		catch (Exception e)
		{
			System.err.println("ERROR!  decrypt threw exception: " + e);
			return null;
		}
	}
}
