package pokemonTypes;

import abilities.Ability;
import pokemon.Pokemon;

public class FireFight extends Pokemon{
	public FireFight(String n, int dexNum, int[] bStats, Ability a, double gRatio){
		super(n, dexNum, bStats, a, gRatio);
	}
	public FireFight(int dexNum,int level){
		super(dexNum,level);
	}
	
	public double getTypeModifier(String at){
		if(at.equals("Water") || at.equals("Ground") || at.equals("Flying") || at.equals("Psychic"))
			return 2.0;
		if(at.equals("Fire") || at.equals("Grass") || at.equals("Ice") || at.equals("Dark"))
			return 0.5;
		if(at.equals("Bug"))
			return 0.25;
		return 0;
	}

	public double getSTABModifier(String at){
		if(at.equals("Fire") || at.equals("Fight"))
			return 1.5;
		return 1.0;
	}

}
