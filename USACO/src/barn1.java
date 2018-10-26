/*
USER: ewong121
TASK: barn1
LANG: JAVA
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class barn1{
	public static void main(String[] args) throws IOException{
		//File f = new File("src/barn1.in");
		//FileWriter fw = new FileWriter("src/barn1.out");
		File f = new File("barn1.in");
		FileWriter fw = new FileWriter("barn1.out");
		Scanner scan = new Scanner(f);
		BufferedWriter bw = new BufferedWriter(fw);
		String firstline = scan.nextLine();
		int numboards = Integer.parseInt(firstline.substring(0, firstline.indexOf(" ")));
		firstline = firstline.substring(firstline.indexOf(" ")+1);
		int numstalls = Integer.parseInt(firstline.substring(0, firstline.indexOf(" ")));
		firstline = firstline.substring(firstline.indexOf(" ")+1);
		int numcows = Integer.parseInt(firstline);
		int[] stalls = new int[numstalls];
		int[] occupied = new int[numcows];
		for(int i = 0; i < numcows; i++)
			occupied[i] = Integer.parseInt(scan.nextLine()) - 1;
		Arrays.sort(occupied);
		int minstalls = occupied[occupied.length-1] - occupied[0] + 1;
		if(numboards == 1){
			bw.write(minstalls + "\n");
			bw.close();
			return;
		}
		if(numboards > numcows){
			bw.write(numcows + "\n");
			bw.close();
			return;
		}
		for(int i = 0; i < numcows; i++)
			stalls[occupied[i]] = 1;
		
		
		int[] spaces = new int[numcows - 1];
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
		bw.write(minstalls+"\n");
		bw.close();
	}
}
