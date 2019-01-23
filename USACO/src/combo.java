
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

public class combo{
	public static void main(String[] args) throws IOException{
		//git-1540355572653
		String src = "src/";
		//String src = "";
		Scanner scan = new Scanner(new File(src + "combo.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(src + "combo.out"));
		int n = Integer.parseInt(scan.nextLine());
		int[] combo1 = new int[3];
		int[] combo2 = new int[3];
		String[] line1 = scan.nextLine().split(" ");
		String[] line2 = scan.nextLine().split(" ");
		for(int i = 0; i < 3; i++){
			combo1[i] = Integer.parseInt(line1[i]);
			combo2[i] = Integer.parseInt(line2[i]);
		}
		
		scan.close();
		bw.close();
	}
}
