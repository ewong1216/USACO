
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
		int nMults = numMultiples(nums);		
		if(nMults == 0){
			bw.write(0 + "\n");
			bw.close();
			return;
		}
		int[][] mults = getMultiples(nMults, nums);
		
		int numsolutions = 0;
		
		scan.close();
		bw.close();
	}
	public static int numMultiples(int[] nums){
		int count = 0;
		for(int i = 0; i < nums.length; i++){
			for(int j = i; j < nums.length; j++){
				if(arrcontains(nums[i] * nums[j], nums))
					count++; 
			}
		}
		return count;
	}
	public static int[][] getMultiples(int count, int[] nums){
		int[][] mults = new int[count][2];
		int track = 0;
		for(int i = 0; i < nums.length; i++){
			for(int j = i; j < nums.length; j++){
				if(arrcontains(nums[i] * nums[j], nums)){
					mults[track][0] = nums[i];
					mults[track][1] = nums[j];
					track++;
				}
			}
		}
		return mults;
	}
	public static boolean containsInts(String s, int[] nums){
		for(int i = 0; i < s.length(); i++){
			if(!arrcontains(Integer.parseInt(s.substring(i, i+1)),nums))
				return false;
		}
		return true;
	}
	
	public static boolean arrcontains(int n, int[] nums){
		for(int i = 0; i < nums.length; i++)
			if(n == nums[i])
				return true;
		return false;
	}
}
