package databases;

import abilities.Ability;
import abilities.BattleAbility;
import pokemon.Pokemon;
import pokemonTypes.Grass;

public class SinnohDatabase{
	public static final Ability[] ABILITIES = {new BattleAbility("Blaze", "Powers up Fire-type moves in a pinch", 1.5),
			new BattleAbility("Overgrow", "Powers up Grass-type moves in a pinch", 1.5), new BattleAbility("Torrent", "Powers up Water-type moves in a pinch", 1.5)};
	public static final Pokemon[] POKEDEX = {new Grass("Turtwig", 1, new int[] {55,68,64,45,55,31}, bSearch("Overgrow"), 87.5),
			new Grass("Grotle",1,new int[] {75,89,85,55,65,36}, bSearch("Overgrow"), 87.5)};
	
	private static Ability bSearch(String abilityName){
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
	
	public static void main(String[] args){
		Grass turtwig = new Grass(1, 5);
		System.out.println(turtwig.battleString());
	}
}
