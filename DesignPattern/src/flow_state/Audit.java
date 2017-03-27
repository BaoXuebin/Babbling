package flow_state;

public class Audit implements FlowState {

	Flow flow;
	
	public Audit(Flow flow) {
		this.flow = flow;
	}

	@Override
	public void handle(Action action) {
		System.out.println(info());
		persit();
		
		if (action == Action.abolish) {
			flow.setFlowState(Flow.abolish);
		}
		if (action == Action.back) {
			flow.setFlowState(Flow.back);
		}
		if (action == Action.pass) {
			flow.setFlowState(Flow.pass);
		}
	}

	@Override
	public String info() {
		String info = "流程到达审查阶段";
		return info;
	}

	@Override
	public void persit() {
		System.out.println("审查阶段的持久化完成");
	}
}
