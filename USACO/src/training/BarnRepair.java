package training;
/*
 * 
 */
//1.4

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
		int[] occupied = new int[numcows];
		for(int i = 0; i < numcows; i++)
			occupied[i] = Integer.parseInt(scan.nextLine());
		for(int i = 0; i < numcows; i++)
			stalls[occupied[i]] = 1;
		int minstalls = occupied[occupied.length-1] - occupied[0] + 1;
		
		int[] spaces = new int[numcows/2];
		int numspaces = 0;
		for(int i = occupied[0] + 1; i < occupied[occupied.length-1]; i++){
			int spacelength = 0;
			while(stalls[i] == 0){
				spacelength++;
				i++;
			}
			if(spacelength > 0){
				spaces[numspaces] = spacelength;
				numspaces++;
			}
		}
		
		Arrays.sort(spaces);
		for(int i = spaces.length-1; i > spaces.length - numboards; i--)
			minstalls -= spaces[i];
		
		System.out.println(minstalls);
	}
}
