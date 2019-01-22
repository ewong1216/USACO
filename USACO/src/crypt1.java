
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
		//String src = "src/";
		String src = "";
		Scanner scan = new Scanner(new File(src + "crypt1.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(src + "crypt1.out"));
		int digitCount = Integer.parseInt(scan.nextLine());
		int[] nums = new int[digitCount];		
		String[] numsline = scan.nextLine().split(" ");
		for(int i = 0; i < digitCount; i++){
			nums[i] = Integer.parseInt(numsline[i]);
		}
		int solutions = 0;
		for(int topleft = 0; topleft < digitCount; topleft++){
			for(int topmid = 0; topmid < digitCount; topmid++){
				for(int topright = 0; topright < digitCount; topright++){
					int topNum = 100*nums[topleft] + 10*nums[topmid] + nums[topright];
					for(int botleft = 0; botleft < digitCount; botleft++){
						int botsum = nums[botleft] * topNum;
						if((botsum+"").length() <= 3){
							for(int botright = 0; botright < digitCount; botright++){
								int topsum = topNum * nums[botright];
								if(containsInts(topsum + "",nums) && containsInts(botsum+"",nums) && containsInts(topsum+ 10*botsum +"",nums) && (topsum+"").length() <=3){
									solutions++;
								}
							}
						}
					}
				}
			}
		}
		bw.write(solutions+"\n");
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
