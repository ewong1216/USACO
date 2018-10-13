package pokemon;

public class Attack{
	private String name;
	private int power;
	private String type;
	private int priority;
	
	public Attack(String n, int p, String t, int pr){
		name = n;
		power = p;
		type = t;
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
	
	public String toString(){
		return "Name: " + name + "\nType: " + type + "\nPower: " + power;
	}
}