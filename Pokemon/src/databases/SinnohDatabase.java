package databases;

import abilities.Ability;
import abilities.BattleAbility;
import pokemon.Attack;
import pokemon.Pokemon;
import pokemonTypes.*;

public class SinnohDatabase{
	public static final Ability[] ABILITIES = {new BattleAbility("Blaze", "Powers up Fire-type moves in a pinch", 1.5),
			new BattleAbility("Overgrow", "Powers up Grass-type moves in a pinch", 1.5), new BattleAbility("Torrent", "Powers up Water-type moves in a pinch", 1.5)};
	public static final Pokemon[] POKEDEX = {
			new Grass("Turtwig",1,new int[]{55,68,64,45,55,31},abSearch("Overgrow"),87.5),
			new Grass("Grotle",2,new int[]{75,89,85,55,65,36},abSearch("Overgrow"),87.5), 
			new GrassGround("Torterra",3,new int[]{95,109,105,75,85,56},abSearch("Overgrow"),87.5),
			new Fire("Chimchar",4,new int[]{44,58,44,58,44,61},abSearch("Blaze"),87.5),
			new FireFight("Monferno",5,new int[]{64,78,52,78,52,81},abSearch("Blaze"),87.5),
			new FireFight("Infernape",6,new int[]{76,104,71,104,71,108},abSearch("Blaze"),87.5),
			new Water("Piplup",7,new int[]{53,51,53,61,56,40},abSearch("Torrent"),87.5),
			new Water("Prinplup",8,new int[]{64,66,68,81,76,50},abSearch("Torrent"),87.5),
			new WaterSteel("Empoleon",9,new int[]{84,86,88,111,101,60},abSearch("Torrent"),87.5)};
	public static final Attack[] ATTACKS = {new Attack("Tackle",35,95,"Normal",0,35,0),new Attack("Withdraw",0,0,"Water",2,40,0)};
	
	
	private static Ability abSearch(String abilityName){
		int min = 0;
		int max = ABILITIES.length -1;
		while(min <= max){
			int mid = (min + max)/2;
			String s = ABILITIES[mid].getName();
			if(s.compareTo(abilityName) < 0){
				min = mid + 1;
			}
			else if(s.compareTo(abilityName) > 0){
				max = mid - 1;
			}
			else
				return ABILITIES[mid];
		}
		return null;
	}
	public static Attack atSearch(String attackName){
		int min = 0;
		int max = ATTACKS.length -1;
		while(min <= max){
			int mid = (min + max)/2;
			String s = ATTACKS[mid].getName();
			if(s.compareTo(attackName) < 0){
				min = mid + 1;
			}
			else if(s.compareTo(attackName) > 0){
				max = mid - 1;
			}
			else
				return ATTACKS[mid];
		}
		return null;
	}
	
	public static void main(String[] args){
		Grass turtwig = new Grass(1, 5);
		System.out.println(turtwig.battleString());
	}
}
