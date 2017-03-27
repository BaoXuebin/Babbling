package flow_state;

public class Abolish implements FlowState {

	Flow flow;
	
	public Abolish(Flow flow) {
		this.flow = flow;
	}

	@Override
	public void handle(Action action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persit() {
		// TODO Auto-generated method stub
		
	}
}
