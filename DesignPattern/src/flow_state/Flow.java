package flow_state;

public class Flow {
	
	public static FlowState audit; // ���
	
	public static FlowState back; // �˻��޸�
	
	public static FlowState abolish; // �ϳ�
	
	public static FlowState pass; // ͨ��
	
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
