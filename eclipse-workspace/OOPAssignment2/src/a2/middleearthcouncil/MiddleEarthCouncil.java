package a2.middleearthcouncil;
import a2.charactermanager.*;

/**
 * MiddleEarthCouncil class - Singleton class designed to provide access to the CharacterManager class. Singleton design pattern
 * ensures that only one instance of MiddleEarthCouncil will exist at any given time. Has two fields, one for the MiddleEarthCouncil
 * instance itself, and one to provide access to the CharacterManager class.
 */
public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	private static CharacterManager manager;
	
	/**
	 * getInstance method - Checks whether or not an instance of MiddleEarthCouncil exists. 
	 * If an instance is found, method returns the MiddleEarthCouncil instance. If it does not exist, 
	 * a new instance is created and returned.
	 * @return instance
	 */
	public static MiddleEarthCouncil getInstance() {
		if (instance == null)
			instance = new MiddleEarthCouncil();
		return instance;
	}
	
	public MiddleEarthCouncil() {
		manager = new CharacterManager();
	}
	
	public static CharacterManager getCharacterManager() {
		return manager;
	}
}
