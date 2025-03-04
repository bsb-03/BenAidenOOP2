package a2.middleearthcharacter;

/**
 * MiddleEarthCharacter Class
 * Has name, health, power
 */
public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	/**
	 * Returns the name of the character
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the character
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the health of the character
	 */
	public double getHealth() {
		return health;
	}
	
	/**
	 * Sets the health of the character
	 */
	public void setHealth(double health) {
		this.health = health;
	}
	
	/**
	 * Gets the power of the character
	 */
	public double getPower() {
		return power;
	}
	
	/**
	 * Sets the power of the character
	 */
	public void setPower(double power) {
		this.power = power;
	}
	
	/**
	 * Constructor
	 * @param name
	 * @param health
	 * @param power
	 * @return
	 */
	public  MiddleEarthCharacter() {
		this.name = "Unknown";
		this.health = 0.0;
		this.power = 0.0;
	}
	
	/**
	 * Abstract method for attack()
	 * @param target
	 * @return
	 */
	abstract boolean attack(MiddleEarthCharacter target);
	
	/**
	 * Abstract method for getRace()
	 * @return
	 */
	abstract String getRace();
	
	void displayInfo() {
		System.out.println("Name: " + this.name + "Health: " + this.health + "Power: " + this.power);
	}
}

/**
 * Elf class
 */
class Elf extends MiddleEarthCharacter {
	private String[] effective = {"Orc"};
	private String[] ineffective = {"Elf", "Dwarf"};
	
	/**
	 * Attack implementation
	 */
	@Override
	boolean attack(MiddleEarthCharacter target) {
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
		return "Elf";
	}
}

/**
 * Dwarf class
 */
class Dwarf extends MiddleEarthCharacter {
	private String[] effective = {"Elf"};
	private String[] ineffective = {"Wizard", "Dwarf"};
	
	/**
	 * Attack implementation
	 */
	@Override
	boolean attack(MiddleEarthCharacter target) {
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
		return "Dwarf";
	}
}

/**
 * Human class
 */
class Human extends MiddleEarthCharacter {
	private String[] effective = {"Wizard"};
	private String[] ineffective = {"Orc", "Human"};
	
	/**
	 * Attack implementation
	 */
	@Override
	boolean attack(MiddleEarthCharacter target) {
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

/**
 * Orc class
 */
class Orc extends MiddleEarthCharacter {
	private String[] effective = {"Human"};
	private String[] ineffective = {"Elf", "Orc"};
	
	/**
	 * Attack implementation
	 */
	@Override
	boolean attack(MiddleEarthCharacter target) {
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
		return "Orc";
	}
}

/**
 * Wizard class
 */
class Wizard extends MiddleEarthCharacter {
	private String[] effective = {"Dwarf"};
	private String[] ineffective = {"Human", "Wizard"};
	
	/**
	 * Attack implementation
	 */
	@Override
	boolean attack(MiddleEarthCharacter target) {
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
		return "Wizard";
	}
}