package encryptionCracker;

import java.math.BigInteger;
import java.util.Arrays;

public class Runner
{
    public static void main(String[] args)
    {
		byte[] encryptedMessage;
		
		// Example code:
		//
		// If you know all the components of the key (the prime p, the shared base g, and the 
		// secrets a and b), then you can just create an instance of the AESCipher to decrypt a message that
		// was encrypted with that key.  For example, if you knew this was the key:
		//
		// p=3, g=2, a=1, b=2
		//
		// Then the following code would encrypt a message with that key
		AESCipher cipher = new AESCipher(3, 2, 1, 2);		// p=3, g=2, a=1, b=2
		encryptedMessage = cipher.encrypt("This is a super-secret sentence.  Don't share with anyone!");
		System.out.print("EXAMPLE: The encrypted bytes are: ");
		System.out.println(Arrays.toString(encryptedMessage));
		
		// And this would decrypt it back to the original clear text
		String clearText = cipher.decrypt(encryptedMessage);
		System.out.print("EXAMPLE: The decrypted message is: ");
		System.out.println(clearText);
		

		// HEY YOU!!  DO THIS!!
		//
		// Implement the method crackTheCode at the bottom of this file!  If you do it right,
		// you'll figure out the secrets a and b for each message, and this test code will
		// correctly print the original secret messages
		//
		// Why did we put an L after all those numbers?  That tells Java to treat them like longs.
		//
		// What's a long?  It's a 64-bit integer.  ints are only 32-bits long.

        // Message #1
        encryptedMessage = new byte[] { -63, 50, -36, -2, 71, -12, 78, 44, 71, -110, -78, -58, -62, 29, -67, -85, -113, 96, -43, -120, -114, -10, -24, 93, -39, -32, -4, 40, 51, 16, 56, 94, -1, -41, 42, -48, -102, 73, -1, 79, 52, 19, -68, 81, -52, -95, -40, -118, -42, -15, 30, -87, 14, -125, 84, 72, 54, 24, 37, 112, 78, -107, -11, 106 };
        System.out.println(crackTheCode(encryptedMessage, 23L, 5L, 8L, 19L));

        // Message #2
		encryptedMessage = new byte[] { -125, 33, 84, 36, -69, 0, -49, 80, -36, 127, 111, 9, 124, -113, 64, -110, 95, 77, 63, -80, -100, -7, 118, 107, -102, -93, -125, 48, -72, -127, -49, 17 };
		System.out.println(crackTheCode(encryptedMessage, 2781347L, 77L, 2706480L, 1608290L));

        // Message #3
		encryptedMessage = new byte[] { 18, -33, -54, -85, -31, 26, 122, 32, 52, 9, 10, -7, 0, -5, 19, -75, -61, -97, -67, 124, 126, 120, -8, -98, -68, -8, 94, 93, -96, -24, -48, -69, 125, 83, -56, 63, -44, 27, -127, 110, -96, -92, 67, 81, 97, 90, 68, 123 };
		System.out.println(crackTheCode(encryptedMessage, 6000011L, 110L, 4712997L, 3024904L));

        // Message #4
		encryptedMessage = new byte[] { -54, -9, -16, 127, 113, 7, -62, -14, -65, 68, 93, 12, 10, 36, -12, 87, 63, -76, -44, 29, 115, -57, -34, -103, 30, 46, 38, -49, 88, -98, 125, 66, -81, 89, 108, 20, -84, 14, 30, 41, -38, -41, -80, 21, 25, 124, 105, 88, 37, 105, 10, 28, 108, -23, 21, 95, -62, 40, -47, -7, -33, 114, -93, -111, 49, -123, -62, 93, -105, -62, 109, -40, -68, 53, -102, -61, -108, 38, 88, -118 };
		System.out.println(crackTheCode(encryptedMessage, 50000017L, 180L, 38538036L, 44408087L));

        // Message #5
 		encryptedMessage = new byte[] { 74, 79, -16, 47, 20, 67, 75, -67, 33, -98, 80, -79, 112, -53, 25, 96, -93, -122, -22, -66, 120, -88, 117, -39, -51, 101, -42, -29, -104, 101, -58, 77, 13, 54, -26, -123, 19, -41, 13, 101, -94, -64, 72, -44, 117, 110, -56, 0 };
		System.out.println(crackTheCode(encryptedMessage, 4000000007L, 97L, 3680927730L, 1473052713L));

        // Message #6--this one might take a while.  I wonder how long...
		encryptedMessage = new byte[] { 82, 60, -99, -90, 30, -116, -61, 111, -72, 122, -127, 112, 38, -72, -96, 59, -126, 32, 28, 126, 92, -9, 27, 88, 3, 91, -116, -69, 32, 36, -115, 38, -5, 100, 32, -50, 68, -11, 25, 62, 41, 83, 66, -79, -3, -117, 127, 39, 17, 31, 73, -4, -110, -100, -63, 58, -50, 53, -44, -118, 71, 5, -108, -87, 76, 69, -67, -57, -122, 75, 100, 88, -44, 39, 68, -122, -93, 48, -28, -94, 126, -66, -2, 117, 127, -56, 121, -57, -43, -16, 29, 123, -36, 35, -20, -39 };
		System.out.println(crackTheCode(encryptedMessage, 1152921504606847009L, 1152921504606846853L, 1122923784221299161L, 856381316028841380L));
    }

 	// Use this helper to compute this expression without overflowing:
    //
    //	(base ^ exponent) % mod
    //
	public static long powerThenMod(long base, long exponent, long mod)
	{
		BigInteger bigBase = BigInteger.valueOf(base);
		BigInteger bigPower = BigInteger.valueOf(exponent);
		BigInteger bigMod = BigInteger.valueOf(mod);

		return bigBase.modPow(bigPower, bigMod).longValue();
	}
	
	// Using just p, g, x, and y, figure out what the secret numbers a and b
	// must be, and then return the decrypted message by using a properly-
	// constructed AESCipher instance, and calling its decrypt method
	public static String crackTheCode(byte[] message, long p, long g, long x, long y)
    {
    	String decryptedMessage = null; 
    	
		// HEY YOU!  PUT CODE HERE!

		// You are given the following, which simulates what an eavesdropper would see
		// on the network in clear-text while Alice and Bob are negotiating a key:
		//
		//      message:        An encrypted message, in the form of an array of bytes
		//      p:  			This is the shared prime p that Alice and Bob agreed on
		//      g:  			This is the shared base that Alice and Bob agreed on
		//		x:				This is the value sent by Alice after she secretly
    	//						decided on her number a.  Rather than sending a, she
    	//						sends x = g^a % p
		//		y:				This is the value sent by Bob after he secretly
    	//						decided on his number b.  Rather than sending b, he
    	//						sends y = g^b % p
		//
		// You must do the following:
		//
		// 1) Figure out what a and b must be, to make these equations work:
		//			x = g^a % p
		//			y = g^b % p
		//	  WARNING!  You can't use ^ in Java, and Math.pow can overflow.  Use
		//		powerThenMod instead (see above).
		//
		// 2) Now that you have p, g, a, and b, you can construct a new AESCipher to
		//		decrypt the message.  Return the result.
    	int a = 0;
    	int b = 0;
    	boolean aSet = false;
    	boolean bSet = false;
    	for(int i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i++){
    		if(aSet && bSet)
    			break;
    		if(x == powerThenMod(g,i,p) && !aSet){
    			a = i;
    			aSet = true;
    		}
    		if(y == powerThenMod(g,i,p) && !bSet){
    			b = i;
    			bSet = true;
    		}
    	}
    	AESCipher cipher = new AESCipher(p, g, a, b);
    	decryptedMessage = cipher.decrypt(message);
    	return decryptedMessage;
    }    

}
