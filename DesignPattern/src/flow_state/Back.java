package flow_state;

public class Back implements FlowState {
	
	Flow flow;
	
	public Back(Flow flow) {
		this.flow = flow;
	}

	@Override
	public void handle(Action action) {
		
	}

	@Override
	public String info() {
		String info = "���̱��˻��޸�";
		return info;
	}

	@Override
	public void persit() {
		// TODO Auto-generated method stub
		
	}

}
