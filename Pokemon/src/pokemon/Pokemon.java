package pokemon;

import databases.SinnohDatabase;

public abstract class Pokemon{
	private String name;
	private int level;
	private int pokedexNum;
	private final static int maxHP = 0;
	private final static int attack = 1;
	private final static int defense = 2;
	private final static int spAttack = 3;
	private final static int spDefense = 4;
	private final static int speed = 5;
	private Stat[] stats = new Stat[6];
	private int[] baseStats;
	private Nature nature;
	private Ability ability;
	/**
	 * Should only be used in the Database Class
	 * 
	 * @param n Pokemon's name
	 * @param Level
	 * @param pokedexNum 
	 * @param bStats int[] of base stats
	 */
	public Pokemon(String n, int level, int pokedexNum, int[] bStats){
		name = n;
		this.level = level;
		nature = new Nature();
		baseStats = bStats;
		for(int i = 0; i < stats.length; i++)
			stats[i] = new Stat(i, level, baseStats[i], nature.getMods()[i]);
	}
	
	/**
	 * Create an instance of a Pokemon, gets data from database
	 * @param pokedexNum
	 * @param level
	 */
	public Pokemon(int pokedexNum, int level){
		Pokemon p = SinnohDatabase.pokedex[pokedexNum];
		name = p.getName();
		this.level = level;
		nature = p.getNature();
		baseStats = p.getBaseStats();
		for(int i = 0; i < stats.length; i++)
			stats[i] = new Stat(i, level, baseStats[i], nature.getMods()[i]);
	}
	public abstract double getTypeModifier(String attackType);
	public abstract double getSTABModifier(String attackType);
	public String getName(){
		return name;
	}
	public int getLevel(){
		return level;
	}
	public Nature getNature(){
		return nature;
	}
	public int[] getBaseStats(){
		return baseStats;
	}
	public Stat[] getStats(){
		return stats;
	}
	public int getPokedexNum(){
		return pokedexNum;
	}
}
