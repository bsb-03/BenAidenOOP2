package a2.middleearthcharacter;

/**
 * Human class
 */
public class Human extends MiddleEarthCharacter {
	private String[] effective = {"Wizard"};
	private String[] ineffective = {"Orc", "Human"};
	
	/**
	 * Attack implementation
	 * @param target - The target character object that the attack is being directed towards
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		double dmgMult = 1.0;
		
		for(int i = 0; i < 2; i++) {
			if(ineffective[i] == target.getRace()) {
				return false;
			}
		}
		
		if(effective[0] == target.getRace()) {
			dmgMult = 1.5;
		}
		
		double damageToDeal = this.getPower() * dmgMult;
		
		double targetCurHp = target.getHealth();
		
		target.setHealth(targetCurHp - damageToDeal);
		
		return true;
	}

	/**
	 * Override for getRace()
	 */
	@Override
	String getRace() {
		return "Human";
	}
}
