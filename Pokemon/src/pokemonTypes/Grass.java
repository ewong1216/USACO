package pokemonTypes;

import pokemon.Pokemon;

public class Grass extends Pokemon{
	
	/**
	 * 
	 * @param n Pokemon name
	 * @param l level
	 * @param pokedexNum 
	 * @param bStats int[] of base stats
	 */
	public Grass(String n, int l, int pokedexNum, int[] bStats){
		super(n,l,pokedexNum,bStats);
	}
	/**
	 * 
	 * @param pokedexNum 
	 * @param l level
	 */
	public Grass(int pokedexNum, int l){
		super(pokedexNum, l);
	}

	public double getTypeModifier(String attackType){
		if(attackType.equals("Fire") || attackType.equals("Ice") || attackType.equals("Flying") || 
				attackType.equals("Bug"))
			return 2.0;
		
		return 0;
	}
	
	public double getSTABModifier(String attackType){
		if(attackType.equals("Grass"))
			return 1.5;
		return 1.0;
	}
}
