package pokemonTypes;

import abilities.Ability;
import pokemon.Pokemon;

public class GrassGround extends Pokemon{

	public GrassGround(String n, int dexNum, int[] bStats, Ability a, double gRatio){
		super(n, dexNum, bStats, a, gRatio);
	}
	public GrassGround(int dexNum, int level){
		super(dexNum,level);
	}

	public double getTypeModifier(String at){
		if(at.equals("Fire") || at.equals("Flying") || at.equals("Bug"))
			return 2.0;
		else if(at.equals("Ice"))
			return 4.0;
		else if(at.equals("Electric"))
			return 0.0;
		else if(at.equals("Ground") || at.equals("Rock"))
			return 0.5;
		return 0;
		
	}

	public double getSTABModifier(String attackType){
		if(attackType.equals("Grass") || attackType.equals("Ground"))
			return 1.5;
		return 1.0;
	}
	
}
