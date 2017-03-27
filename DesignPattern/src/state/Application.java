package state;

public class Application {
	public static void main(String[] args) {
		Gun gun = new Gun();
		gun.fire();
		gun.fire();
		gun.fire();
		gun.fire();
		gun.load();
		gun.fire();
	}

}
