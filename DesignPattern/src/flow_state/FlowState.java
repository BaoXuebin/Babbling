package flow_state;

public interface FlowState {
	
	void persit();
	
	void handle(Action action);
	
	String info();
}
