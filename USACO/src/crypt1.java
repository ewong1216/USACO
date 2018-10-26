
/*
ID: ewong121
TASK: crypt1
LANG: JAVA
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class crypt1{
	public static void main(String[] args) throws IOException{
		File f = new File("src/crypt1.in");
		FileWriter fw = new FileWriter("src/crypt1.out");
		//File f = new File("crypt1.in");
		//FileWriter fw = new FileWriter("crypt1.out");
		Scanner scan = new Scanner(f);
		BufferedWriter bw = new BufferedWriter(fw);
		int size = Integer.parseInt(scan.nextLine());
		int[] nums = new int[size];		
		String numsline = scan.nextLine();
		for(int count = 0; numsline.contains(" "); count++){
			nums[count] = Integer.parseInt(numsline.substring(0,1));
			numsline = numsline.substring(numsline.indexOf(" ") + 1);
		}
		nums[nums.length-1] = Integer.parseInt(numsline);
		int numsolutions = 0;
		
		scan.close();
		bw.close();
	}

}
