package state;

public class Zero extends State {
	Gun gun;
	public Zero(Gun gun) {
		this.gun = gun;
	}
	@Override
	public void loadBullet() {
		System.out.println("装弹");
		gun.setState(gun.three);
	}

	@Override
	public void shoot() {
		System.out.println("没有子弹了");
	}

}
