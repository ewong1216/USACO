package pokemon;

import abilities.Ability;
import databases.SinnohDatabase;
import java.util.Random;

public abstract class Pokemon{
	private String name;
	private int level;
	private int pokedexNum;
	private final static int MAXHP = 0;
	private final static int ATTACK = 1;
	private final static int DEFENSE = 2;
	private final static int SPECIAL_ATTACK = 3;
	private final static int SPECIAL_DEFENSE = 4;
	private final static int SPEED = 5;
	private Stat[] stats = new Stat[6];
	private int[] baseStats;
	private int gender;
	private int curHP;
	private double genderRatio;
	private Nature nature;
	private Ability ability;
	private Attack[] attacks;
	/**
	 * Should only be used in the Database Class
	 * 
	 * @param n Pokemon's name
	 * @param pokedexNum 
	 * @param bStats int[] of base stats
	 */
	public Pokemon(String n, int dexNum, int[] bStats, Ability a, double gRatio){
		name = n;	
		pokedexNum = dexNum;
		baseStats = bStats;
		ability = a;
		genderRatio = gRatio;
	}
	
	/**
	 * Create an instance of a Pokemon, gets data from database
	 * @param pokedexNum
	 * @param level
	 */
	public Pokemon(int dexNum, int l){
		Pokemon p = SinnohDatabase.POKEDEX[dexNum-1];
		pokedexNum = dexNum;
		name = p.getName();
		level = l;
		nature = new Nature();
		baseStats = p.getBaseStats();
		for(int i = 0; i < stats.length; i++)
			stats[i] = new Stat(i, level, baseStats[i], nature.getMods()[i]);
		ability = p.getAbility();
		genderRatio = p.getGenderRatio();
		if(new Random().nextInt(100) < genderRatio)
			gender = 1;
		else if(genderRatio == -1.0)
			gender = 0;
		else
			gender = 2;
		curHP = stats[MAXHP].getValue();
	}
	
	public String battleString(){
		String s = name;
		while(s.length() < 16)
			s += " ";
		s += "Lv. " + level + " " + genderChar(gender) + "\n" + "HP: ";
		double hppercent = curHP / stats[MAXHP].getValue();
		for(double i = 0; i < hppercent; i+= .05)
			s += "\u25A0";
		return s;
	}
	
	public String toString(){
		String bs = battleString();
		String s = bs.substring(0,bs.indexOf(":")+2) + curHP + "/" + stats[MAXHP].getValue() + "\n";
		for(int i = 1; i < 6; i++)
			s += stats[i].toString() + "\n";
		return s;
	}
	
	
	
	
	
	
	
	
	
	public abstract double getTypeModifier(String at);
	public abstract double getSTABModifier(String at);
	public String getName(){
		return name;
	}
	public int getLevel(){
		return level;
	}
	public Nature getNature(){
		return nature;
	}
	private int[] getBaseStats(){
		return baseStats;
	}
	public Stat[] getStats(){
		return stats;
	}
	public int getPokedexNum(){
		return pokedexNum;
	}
	public Ability getAbility(){
		return ability;
	}
	private double getGenderRatio(){
		return genderRatio;
	}
	public boolean isFainted(){
		if(curHP == 0)
			return true;
		return false;
	}
	private String genderChar(int i){
		if(i == 1)
			return " M";
		if(i == 2)
			return " F";
		return "NA";
	}
}
