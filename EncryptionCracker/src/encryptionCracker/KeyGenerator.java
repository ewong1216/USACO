package encryptionCracker;

import java.math.BigInteger;
import java.util.Scanner;

//--------------------------------------------------------
// NOTE!!!!  Look at RUNNER.JAVA first
//
// THIS IS YOUR DESSERT.  EAT DINNER FIRST.
//
// Finish the lab first, inside Runner.java.
//
// If you finish early and want to explore,
// you can try calling createKey to generate your own key, and encrypt your own messages
//--------------------------------------------------------

public class KeyGenerator 
{
	public static void main(String[] args) 
	{
		
	}
	
	public static void createKey()
	{
		Scanner console = new Scanner(System.in);
		System.out.print("Type a lower bound for picking the next prime ");
		long min = console.nextLong();
		long p = getNextPrime(min);
		System.out.print("\nPicked prime " + p + ".  Go to https://www.wolframalpha.com/input/?i=all+primitive+roots+of+" + p + " to find a suitable primitive root g and type it here ");
		long g = console.nextLong();

		System.out.print("\nType a, or type 0 to randomly-generate a and b ");
		long a = console.nextLong();
		long b;
		if (a == 0)
		{
			a = (long) (Math.random() * (0.9 * p) + 1);
			b = (long) (Math.random() * (0.9 * p) + 1);
		}
		else
		{
			System.out.print("\nType b ");
			b = console.nextLong();
		}
		
		BigInteger bigA = BigInteger.valueOf(a);
		BigInteger bigB = BigInteger.valueOf(b);
		BigInteger bigP = BigInteger.valueOf(p);
		BigInteger bigG = BigInteger.valueOf(g);
		BigInteger x = bigG.modPow(bigA, bigP);
		BigInteger y = bigG.modPow(bigB, bigP);
		BigInteger key = bigG.modPow(bigA.multiply(bigB), bigP);
		System.out.println("p=" + p + ", g=" + g + ", a=" + a + ", b=" + b + ", x=" + x + ", y=" + y + ", key=" + key);
	}


	// Returns boolean indicating whether the parameter is prime
	private static boolean isPrime(long n)
	{
		if (n == 2)
		{
			return true;
		}

		for (long i=2; i*i <= n; i++)
		{
			if ((n % i) == 0)
			{
				return false;
			}
		}

		return true;
	}

	// Start listing primes indefinitely, starting at min
	private static long getNextPrime(long min)
	{
		for (long n = min; ; n++)
		{
			if (isPrime(n))
			{
				return n;
			}
		}
	}
}
