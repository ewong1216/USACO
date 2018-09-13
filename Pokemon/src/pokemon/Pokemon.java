package pokemon;

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
	
	public Pokemon(String n, int l){
		name = n;
		level = l;
		nature = new Nature();
		for(int i = 0; i < stats.length; i++)
			stats[i] = new Stat(i,l,baseStats[i],nature.getMods()[i]);
		
	}
}
