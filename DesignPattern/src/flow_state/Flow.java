package flow_state;

public class Flow {
	
	public static FlowState audit; // 审查
	
	public static FlowState back; // 退回修改
	
	public static FlowState abolish; // 废除
	
	public static FlowState pass; // 通过
	
	public FlowState state;
	
	public Flow() {
		audit = new Audit(this);
		back = new Back(this);
		abolish = new Abolish(this);
		pass = new Pass(this);
		
		state = audit;
	}
	
	public void setFlowState(FlowState flowState) {
		this.state = flowState;
	}
	
	public void handle(Action action) {
		state.handle(action);
	}
}
