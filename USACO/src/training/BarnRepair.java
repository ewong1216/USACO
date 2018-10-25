package training;
/*
 * 
 */
//1.4

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BarnRepair{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scan = new Scanner(new File("src/barn1.in"));
		String firstline = scan.nextLine();
		int numboards = Integer.parseInt(firstline.substring(0, firstline.indexOf(" ")));
		firstline = firstline.substring(firstline.indexOf(" ")+1);
		int numstalls = Integer.parseInt(firstline.substring(0, firstline.indexOf(" ")));
		firstline = firstline.substring(firstline.indexOf(" ")+1);
		int numcows = Integer.parseInt(firstline);
		int[] stalls = new int[numstalls];
		for(int i = 0; i < numcows; i++)
			stalls[Integer.parseInt(scan.nextLine())] = 1;
		//int minstalls = 
	}
}
