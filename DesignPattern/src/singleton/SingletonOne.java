package singleton;

public class SingletonOne {

	private static SingletonOne instance = null;
	
	private SingletonOne() {
		
	}
	
	public static SingletonOne getInstance() {
		if (instance == null)
			instance = new SingletonOne();
		
		return instance;
	}
	
	public static void setEmpty() {
		instance = null;
	}
}
