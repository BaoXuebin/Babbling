package singleton;

public class Thread4 extends Thread {

	private int count = 1;
	private SingletonOne instance;
	
	public SingletonOne getInstance() {
		return instance;
	}

	public void setInstance(SingletonOne instance) {
		this.instance = instance;
	}

	@Override
	public void run() {
		while (count < 100) {
			if (count == 50) {
				setInstance(SingletonOne.getInstance());
			}
			count ++;
		}
	}
}	
