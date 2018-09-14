package pokemon;
import java.util.Random;

public class Stat{
	private int stat;
	private int value;
	private int base;
	private final int iv = new Random().nextInt(31) + 1;
	private int ev;
	private double natureMod;
	
	/**
	 * @param s the int that represents which stat
	 * @param l the level of the pokemon
	 * @param b the base stat of the pokemon's stat
	 * @param n the nature modification of the stat	
	 */
	public Stat(int s, int l, int b, double n){
		stat = s;
		ev = 0;
		natureMod = n;
		base = b;
		setValue(l);
	}
	/**
	 * Adds EV to the stat, if applicable.
	 * 
	 * @param e the value to add to this stat's EV
	 */
	public void addEv(int e){
		if(ev < 252){
			if(ev + e <= 252)
				ev += e;
			else
				ev = 252;
		}
	}
	/**
	 * Updates the value of the stat according to the level.
	 * @param level the level of the pokemon 
	 */
	public void setValue(int level){
		if(stat == 0){
			value = (2*base + iv + ev/4) * level / 100 + level + 10;
		}
		value = (int) (((2*base + iv + ev/4) * level / 100 + 5) * natureMod);
	}
	/**
	 * 
	 * @return value of the stat
	 */
	public int getValue(){
		return value;
	}
}
