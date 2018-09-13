package pokemon;

import databases.SinnohDatabase;

public class Nature{
	String name;
	private final static int maxHP = 0;
	private final static int attack = 1;
	private final static int defense = 2;
	private final static int spAttack = 3;
	private final static int spDefense = 4;
	private final static int speed = 5;
	private double[] statMods = new double[6];
	
	public Nature(String n){
		name = n;
		if(n.equals("Lonely")){
			statMods[attack] += 0.1;
			statMods[defense] -= 0.1;
		}
		
	}
}
