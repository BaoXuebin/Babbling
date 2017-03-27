package state;

public class Two extends State {
	Gun gun;
	public Two(Gun gun) {
		this.gun = gun;
	}
	@Override
	public void loadBullet() {
		System.out.println("无法装弹");
	}

	@Override
	public void shoot() {
		System.out.println("射出一颗子弹------o");
		gun.setState(gun.one);
	}

}
