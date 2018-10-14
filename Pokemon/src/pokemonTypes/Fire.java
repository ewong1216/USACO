package pokemonTypes;

import abilities.Ability;
import pokemon.Pokemon;

public class Fire extends Pokemon{

	public Fire(String n, int dexNum, int[] bStats, Ability a, double gRatio){
		super(n, dexNum, bStats, a, gRatio);
	}
	public Fire(int dexNum,int level){
		super(dexNum,level);
	}

	public double getTypeModifier(String at){
		if(at.equals("Water") || at.equals("Ground") || at.equals("Rock"))
			return 2.0;
		if(at.equals("Fire") || at.equals("Grass") || at.equals("Ice") || at.equals("Bug"))
			return 0.5;
		return 0;
	}

	public double getSTABModifier(String at){
		if(at.equals("Fire"))
			return 1.5;
		return 1.0;
	}

}
