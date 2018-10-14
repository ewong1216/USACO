package pokemonTypes;

import abilities.Ability;
import pokemon.Pokemon;

public class WaterSteel extends Pokemon{
	public WaterSteel(String n, int dexNum, int[] bStats, Ability a, double gRatio){
		super(n, dexNum, bStats, a, gRatio);
	}
	public WaterSteel(int dexNum,int level){
		super(dexNum,level);
	}
	
	public double getTypeModifier(String at){
		if(at.equals("Electric") || at.equals("Fighting") || at.equals("Ground"))
			return 2.0;
		if(at.equals("Normal") || at.equals("Water") || at.equals("Ice") || at.equals("Flying") || at.equals("Psychic") || at.equals("Bug") || at.equals("Rock") ||
				at.equals("Ghost") || at.equals("Dragon") || at.equals("Dark") || at.equals("Steel"))
			return 0.5;
		if(at.equals("Ice"))
			return 0.25;
		if(at.equals("Poison"))
			return 0.0;
		return 1.0;
	}
	
	public double getSTABModifier(String at){
		if(at.equals("Water") || at.equals("Steel"))
			return 1.5;
		return 1.0;
	}
}
