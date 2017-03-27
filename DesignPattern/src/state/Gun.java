package state;

public class Gun {
	public State three,two,one,zero;
	private State state;
	public Gun() {
		three = new Three(this);
		two = new Two(this);
		one = new One(this);
		zero = new Zero(this);
		state = three;
	}
	public void setState(State state){
		this.state = state;
	}
	public void fire(){
		state.shoot();
	}
	public void load(){
		state.loadBullet();
	}
}
