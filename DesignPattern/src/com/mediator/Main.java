package com.mediator;


public class Main {
	public static void main(String[] args) {
		Mediator mediator = new ConcreteMediator();
		Colleague A = new ConcreteColleague();
		Colleague B = new ConcreteColleague();
		Colleague A1 = new ConcreteColleague();
		Colleague B1 = new ConcreteColleague();
		A.setMediator(mediator);
		B.setMediator(mediator);
		A1.setMediator(mediator);
		B1.setMediator(mediator);
		A.setName("出租A");
		B.setName("出租B");
		A1.setName("求租A1");
		B1.setName("求租B1");
		A.giveMess("出租100平米的房子，500元/月", "求租A1","求租B1");
		A1.giveMess("有意向租用，按500元/月", "出租A");
	}

}
