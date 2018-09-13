package pokemon;
import java.util.Random;

public class Stat{
	private int stat;
	private int value;
	private int base;
	private final int iv = new Random().nextInt(31) + 1;
	private int ev;
	private double natureMod;
	public Stat(int s, int l, int b, double n){
		stat = s;
		ev = 0;
		natureMod = n;
		setValue(l);
	}
	public void addEv(int e){
		if(ev < 252){
			if(ev + e <= 252)
				ev += e;
			else
				ev = 252;
		}
	}
	private void setValue(int level){
		if(stat == 0){
			value = (2*base + iv + ev/4) * level / 100 + level + 10;
		}
		value = (int) (((2*base + iv + ev/4) * level / 100 + 5) * natureMod);
	}
	
	public int value(){
		return value;
	}
}
