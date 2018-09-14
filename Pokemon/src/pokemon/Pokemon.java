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
	/**
	 * 
	 * @param n Pokemon's name
	 * @param l Level
	 * @param pokedexNum 
	 * @param bStats int[] of base stats
	 */
	public Pokemon(String n, int l, int pokedexNum, int[] bStats){
		name = n;
		level = l;
		nature = new Nature();
		baseStats = bStats;
		for(int i = 0; i < stats.length; i++)
			stats[i] = new Stat(i, level, baseStats[i], nature.getMods()[i]);
		
	}
	
	/**
	 * 
	 * @param pokedexNum
	 * @param l level
	 */
	public Pokemon(int pokedexNum, int l){
		Pokemon p = SinnohDatabase.pokedex[pokedexNum];
		name = p.getName();
		level = l;
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
