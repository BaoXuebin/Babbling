package state;

public class One extends State {
	Gun gun;
	public One(Gun gun) {
		this.gun = gun;
	}
	@Override
	public void loadBullet() {
		System.out.println("�޷�װ��");
	}

	@Override
	public void shoot() {
		System.out.println("���һ���ӵ�----O");
		gun.setState(gun.zero);
	}
	
}
