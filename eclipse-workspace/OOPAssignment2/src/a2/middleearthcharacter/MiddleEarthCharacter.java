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
	 * 
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
	 * Parameterized constructor
	 * @param name
	 * @param health
	 * @param power
	 * @return
	 */
	public static MiddleEarthCharacter newMiddleEarthCharacter(String name, double health, double power) {
		MiddleEarthCharacter newChar = new MiddleEarthCharacter();
		
		newChar.name = name;
		newChar.health = health;
		newChar.power = power;
		
		return newChar;
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
	@Override
	boolean attack(MiddleEarthCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Override for getRace()
	 */
	@Override
	String getRace() {
		return "Elf";
	}
}

class Dwarf extends MiddleEarthCharacter {
	private String[] effective = {"Elf"};
	private String[] ineffective = {"Wizard", "Dwarf"};
	
	@Override
	boolean attack(MiddleEarthCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Override for getRace()
	 */
	@Override
	String getRace() {
		return "Dwarf";
	}
}

class Human extends MiddleEarthCharacter {
	private String[] effective = {"Wizard"};
	private String[] ineffective = {"Orc", "Human"};
	
	@Override
	boolean attack(MiddleEarthCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Override for getRace()
	 */
	@Override
	String getRace() {
		return "Human";
	}
}

class Orc extends MiddleEarthCharacter {
	private String[] effective = {"Human"};
	private String[] ineffective = {"Elf", "Orc"};
	
	@Override
	boolean attack(MiddleEarthCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * Override for getRace()
	 */
	@Override
	String getRace() {
		return "Orc";
	}
}

class Wizard extends MiddleEarthCharacter {
	private String[] effective = {"Dwarf"};
	private String[] ineffective = {"Human", "Wizard"};
	
	@Override
	boolean attack(MiddleEarthCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * Override for getRace()
	 */
	@Override
	String getRace() {
		return "Wizard";
	}
}