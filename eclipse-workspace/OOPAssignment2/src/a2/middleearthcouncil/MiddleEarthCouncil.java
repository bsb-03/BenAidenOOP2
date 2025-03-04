package a2.middleearthcouncil;

class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	
	public static MiddleEarthCouncil getInstance() {
		if (instance == null)
			instance = new MiddleEarthCouncil();
		return instance;
	}
	
}
