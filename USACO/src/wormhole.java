import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
ID: ewong121
TASK: wormhole
LANG: JAVA
 */
public class wormhole{
	public static void main(String[] args) throws IOException{
		//git-1540355572653
		//String src = "src/";
		String src = "";
		Scanner scan = new Scanner(new File(src + "combo.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(src + "combo.out"));
		int n = Integer.parseInt(scan.nextLine());
		int[] xs = new int[n];
		int[] ys = new int[n];
		for(int i = 0; i < n; i++){
			String[] line = scan.nextLine().split(" ");
			xs[n] = Integer.parseInt(line[0]);
			ys[n] = Integer.parseInt(line[1]);
		}
		
	}
}
