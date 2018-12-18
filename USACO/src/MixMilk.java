import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class MixMilk{

	public static void main(String[] args) throws IOException{
		String src = "src/";
		//String src = "";
		Scanner scan = new Scanner(new File(src + "mixmilk.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(src + "mixmilk.out"));
		int[] caps = new int[3];
		int[] amts = new int[3];
		String line = scan.nextLine();
		caps[0] = Integer.parseInt(line.substring(0, line.indexOf(" ")));
		amts[0] = Integer.parseInt(line.substring(line.indexOf(" ")+1));
		line = scan.nextLine();
		caps[1] = Integer.parseInt(line.substring(0, line.indexOf(" ")));
		amts[1] = Integer.parseInt(line.substring(line.indexOf(" ")+1));
		line = scan.nextLine();
		caps[2] = Integer.parseInt(line.substring(0, line.indexOf(" ")));
		amts[2] = Integer.parseInt(line.substring(line.indexOf(" ")+1));
		
		Bucket[] buckets = new Bucket[3];
		for(int i = 0; i < 3; i++){
			buckets[i] = new Bucket(caps[i], amts[i]);
		}
		
		int pour = 0;
		
		for(int i = 0; i < 100; i++){
			pour(buckets[pour], buckets[(pour+1) % 3]);
			pour = (pour + 1) % 3;
		}
		
		for(int i = 0; i < 3; i++){
			bw.write(buckets[i].amt + "\n");
		}
		
		scan.close();
		bw.close();
	}
	
	private static void pour(Bucket b1, Bucket b2){
		if(b1.amt + b2.amt <= b2.cap){
			b2.amt += b1.amt;
			b1.amt = 0;
		}
		else{
			b1.amt -= b2.cap - b2.amt;
			b2.amt = b2.cap;
		}
	}
}
class Bucket{
	int cap;
	int amt;
	
	public Bucket(int c, int a){
		cap = c;
		amt = a;
	}
}