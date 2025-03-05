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
	public MiddleEarthCharacter() {
		this.name = "Unknown";
		this.health = 0.0;
		this.power = 0.0;
	}
	
	/**
	 * Abstract method for attack()
	 * @param target
	 * @return
	 */
	public abstract boolean attack(MiddleEarthCharacter target);
	
	/**
	 * Abstract method for getRace()
	 * @return
	 */
	abstract String getRace();
	
	/**
	 * Displays character information
	 */
	public void displayInfo() {
		System.out.println("Name: " + this.name + " Health: " + this.health + " Power: " + this.power);
	}
}
