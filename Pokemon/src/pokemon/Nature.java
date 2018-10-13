package pokemon;

import java.util.Random;

public class Nature{
	String name;
	private final static int attack = 1;
	private final static int defense = 2;
	private final static int spAttack = 3;
	private final static int spDefense = 4;
	private final static int speed = 5;
	private double[] statMods = new double[6];
	private final static String[] natures = {"Hardy","Docile","Serious","Bashful","Quirky","Lonely","Brave","Adamant","Naughty",
			"Bold","Relaxed","Impish","Lax","Timid","Hasty","Jolly","Naive","Modest","Mild","Quiet","Rash","Careful",
			"Sassy","Gentle","Calm"};
	public Nature(){
		statMods[0] = 1.0;
		int r = new Random().nextInt(25);
		name = natures[r];
		for(int i = 0; i < statMods.length; i++)
			statMods[i] = 1.0;
		if(name.equals("Hardy") || name.equals("Docile") || name.equals("Serious") || name.equals("Bashful") || name.equals("Quirky"))
			return;
		if(name.equals("Lonely") || name.equals("Brave") || name.equals("Adamant") || name.equals("Naughty")){
			statMods[attack] += 0.1;
			if(name.equals("Naughty"))
				statMods[spDefense] -= 0.1;
			else if(name.equals("Adamant"))
				statMods[spAttack] -= 0.1;
			else if(name.equals("Brave"))
				statMods[speed] -= 0.1;
			else
				statMods[defense] -= 0.1;
		}
		else if(name.equals("Bold") || name.equals("Relaxed") || name.equals("Impish") || name.equals("Lax")){
			statMods[defense] += 0.1;
			if(name.equals("Lax"))
				statMods[spDefense] -= 0.1;
			else if(name.equals("Impish"))
				statMods[spAttack] -= 0.1;
			else if(name.equals("Relaxed"))
				statMods[speed] -= 0.1;
			else
				statMods[attack] -= 0.1;
		}
		else if(name.equals("Timid") || name.equals("Hasty") || name.equals("Jolly") || name.equals("Naive")){
			statMods[speed] += 0.1;
			if(name.equals("Naive"))
				statMods[spDefense] -= 0.1;
			else if(name.equals("Jolly"))
				statMods[spAttack] -= 0.1;
			else if(name.equals("Hasty"))
				statMods[defense] -= 0.1;
			else
				statMods[attack] -= 0.1;
		}
		else if(name.equals("Modest") || name.equals("Mild") || name.equals("Quiet") || name.equals("Rash")){
			statMods[spAttack] += 0.1;
			if(name.equals("Rash"))
				statMods[spDefense] -= 0.1;
			else if(name.equals("Quiet"))
				statMods[speed] -= 0.1;
			else if(name.equals("Mild"))
				statMods[defense] -= 0.1;
			else
				statMods[attack] -= 0.1;
		}
		else{
			statMods[spDefense] += 0.1;
			if(name.equals("Careful"))
				statMods[spAttack] -= 0.1;
			else if(name.equals("Sassy"))
				statMods[speed] -= 0.1;
			else if(name.equals("Gentle"))
				statMods[defense] -= 0.1;
			else
				statMods[attack] -= 0.1;
		}
	}
	public String getName(){
		return name;
	}
	public double[] getMods(){
		return statMods;
	}
}
