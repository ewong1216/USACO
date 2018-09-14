package pokemon;

public class Attack{
	private String name;
	private int power;
	private String type;
	
	public Attack(String n, int p, String t){
		name = n;
		power = p;
		type = t;
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
}
