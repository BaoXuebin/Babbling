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
		A.setName("����A");
		B.setName("����B");
		A1.setName("����A1");
		B1.setName("����B1");
		A.giveMess("����100ƽ�׵ķ��ӣ�500Ԫ/��", "����A1","����B1");
		A1.giveMess("���������ã���500Ԫ/��", "����A");
	}

}
