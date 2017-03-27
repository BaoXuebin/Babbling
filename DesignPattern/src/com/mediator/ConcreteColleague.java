package com.mediator;

public class ConcreteColleague implements Colleague {
	Mediator mediator;
	String name;
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void giveMess(String mess, String... person) {
		String s = name+"给出的信息："+mess;
		mediator.deliverMess(s, person);
	}

	@Override
	public void receiverMess(String mess) {
		System.out.println(name+"收到的信息：");
		System.out.println("\t"+mess);

	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
		mediator.registerColleague(this);
	}

	@Override
	public void setName(String s) {
		this.name = s;
	}

}
