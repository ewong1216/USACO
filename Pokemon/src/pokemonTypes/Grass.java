package pokemonTypes;

import pokemon.Pokemon;

public class Grass extends Pokemon{
	
	/**
	 * Should only be used in Database class
	 * 
	 * @param n Pokemon name
	 * @param level
	 * @param pokedexNum 
	 * @param bStats int[] of base stats
	 */
	public Grass(String n, int level, int pokedexNum, int[] bStats){
		super(n,level,pokedexNum,bStats);
	}
	/**
	 * Creates an instance of a Grass pokemon
	 * 
	 * @param pokedexNum 
	 * @param level
	 */
	public Grass(int pokedexNum, int level){
		super(pokedexNum, level);
	}
	
	/**
	 * @param attackType 
	 * @return returns the multiplier that describes the effectiveness of the attack agianst a Grass Pokemon
	 */
	public double getTypeModifier(String attackType){
		if(attackType.equals("Fire") || attackType.equals("Ice") || attackType.equals("Flying") || 
				attackType.equals("Poison") || attackType.equals("Bug"))
			return 2.0;
		if(attackType.equals("Water") || attackType.equals("Electric") || attackType.equals("Grass") || 
				attackType.equals("Ground"))
			return 0.5;
		return 1.0;
	}
	
	public double getSTABModifier(String attackType){
		if(attackType.equals("Grass"))
			return 1.5;
		return 1.0;
	}
}
