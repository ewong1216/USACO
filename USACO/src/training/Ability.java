package abilities;

public abstract class Ability{
	private String name;
	private String effect;
	
	public Ability(String n, String e){
		name = n;
		effect = e;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return name +": " + effect;
	}
}
