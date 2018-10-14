package pokemonTypes;

import abilities.Ability;
import pokemon.Pokemon;

public class Water extends Pokemon{
	public Water(String n, int dexNum, int[] bStats, Ability a, double gRatio){
		super(n, dexNum, bStats, a, gRatio);
	}
	public Water(int dexNum,int level){
		super(dexNum,level);
	}
	
	public double getTypeModifier(String at){
		if(at.equals("Grass") || at.equals("Electric"))
			return 2.0;
		if(at.equals("Fire") || at.equals("Water") || at.equals("Ice"))
			return 0.5;
		return 1.0;
	}
	
	public double getSTABModifier(String at){
		if(at.equals("Water"))
			return 1.5;
		return 1.0;
	}
	
}
