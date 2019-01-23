
/*
ID: ewong121
TASK: combo
LANG: JAVA
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class combo{
	public static void main(String[] args) throws IOException{
		//git-1540355572653
		//String src = "src/";
		String src = "";
		Scanner scan = new Scanner(new File(src + "combo.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(src + "combo.out"));
		int n = Integer.parseInt(scan.nextLine());
		if(n < 5){
			bw.write((int) Math.pow(n, 3) + "\n");
			bw.close();
			scan.close();
			return;
		}
		int[] comboF = new int[3]; //combo farmer
		int[] comboM = new int[3]; //combo master
		String[] line1 = scan.nextLine().split(" ");
		String[] line2 = scan.nextLine().split(" ");
		for(int i = 0; i < 3; i++){
			comboF[i] = Integer.parseInt(line1[i]);
			comboM[i] = Integer.parseInt(line2[i]);
		}
		HashSet<String> combos = new HashSet<String>(500); //Will never have more than 250 combos
		for(int digit0 = comboF[0] - 2; digit0 <= comboF[0] + 2; digit0++){
			for(int digit1 = comboF[1] - 2; digit1 <= comboF[1] + 2; digit1++){
				for(int digit2 = comboF[2] - 2; digit2 <= comboF[2] + 2; digit2++){
					String combo = cycle(n,digit0) + cycle(n, digit1) + cycle(n,digit2);
					if(!combos.contains(combos)){
						combos.add(combo);
					}
				}
			}
		}
		for(int digit0 = comboM[0] - 2; digit0 <= comboM[0] + 2; digit0++){
			for(int digit1 = comboM[1] - 2; digit1 <= comboM[1] + 2; digit1++){
				for(int digit2 = comboM[2] - 2; digit2 <= comboM[2] + 2; digit2++){
					String combo = cycle(n,digit0) + cycle(n, digit1) + cycle(n,digit2);
					if(!combos.contains(combos)){
						combos.add(combo);
					}
				}
			}
		}
		bw.write(combos.size() + "\n");
		scan.close();
		bw.close();
	}
	private static String cycle(int n, int i){
		if(i > n){
			return i - n + "";
		}
		if(i == 0){
			return n + "";
		}
		if(i == -1){
			return n - 1 + "";
		}
		return i+"";
	}
}
