package pokemon;

import databases.SinnohDatabase;

public class Pokemon{
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
	
	public Pokemon(String n, int l, int[] bStats){
		name = n;
		level = l;
		nature = new Nature();
		baseStats = bStats;
		for(int i = 0; i < stats.length; i++)
			stats[i] = new Stat(i, level, baseStats[i], nature.getMods()[i]);
		
	}
	public Pokemon(int pokedexNum, int l){
		Pokemon p = SinnohDatabase.pokedex[pokedexNum];
		name = p.getName();
		level = l;
		nature = p.getNature();
		baseStats = p.getBaseStats();
		for(int i = 0; i < stats.length; i++)
			stats[i] = new Stat(i, level, baseStats[i], nature.getMods()[i]);
	}
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
