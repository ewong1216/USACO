package abilities;

public class BattleAbility extends Ability{
	private boolean active;
	private double modifier;
	
	public BattleAbility(String name, String effect, double m){
		super(name, effect);
		modifier = m;
	}
	
	public double getEffect(){
		if(active)
			return modifier;
		return 1.0;
	}
}
