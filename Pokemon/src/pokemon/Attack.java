package pokemon;

public class Attack{
	private String name;
	private int power;
	private String type;
	private int category; //0 = physical, 1 = special, 2 = status
	private int accuracy;
	private int ppmax;
	private int ppcur;
	private int priority;
	
	/**
	 * Database constructor
	 * @param n name
	 * @param p power
	 * @param a accuracy
	 * @param t type
	 * @param c category
	 * @param ppp 
	 * @param pr priority
	 */
	public Attack(String n, int p, int a, String t, int c, int ppp, int pr){
		name = n;
		power = p;
		accuracy = a;
		type = t;
		category = c;
		ppmax = ppp;
		priority = pr;
	}

	public String getName(){
		return name;
	}
	public int getPower(){
		return power;
	}
	
	public String getType(){
		return type;
	}
	public int getCategory(){
		return category;
	}
	public int getAccuracy(){
		return accuracy;
	}
	public void resetPP(){
		ppcur = ppmax;
	}
	public boolean usePP(){
		if(ppcur > 0){
			ppcur--;
			return true;
		}
		return false;
	}
	public int getPriority(){
		return priority;
	}
	public String toString(){
		return "Name: " + name + "\nType: " + type + "\nPower: " + power;
	}
}