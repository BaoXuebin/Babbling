package state;

public class Two extends State {
	Gun gun;
	public Two(Gun gun) {
		this.gun = gun;
	}
	@Override
	public void loadBullet() {
		System.out.println("�޷�װ��");
	}

	@Override
	public void shoot() {
		System.out.println("���һ���ӵ�------o");
		gun.setState(gun.one);
	}

}
