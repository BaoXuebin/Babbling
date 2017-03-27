package state;

public class One extends State {
	Gun gun;
	public One(Gun gun) {
		this.gun = gun;
	}
	@Override
	public void loadBullet() {
		System.out.println("无法装弹");
	}

	@Override
	public void shoot() {
		System.out.println("射出一颗子弹----O");
		gun.setState(gun.zero);
	}
	
}
