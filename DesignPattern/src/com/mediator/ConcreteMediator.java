package com.mediator;

import java.util.ArrayList;

public class ConcreteMediator implements Mediator {
	
	ArrayList<Colleague> list;
	public ConcreteMediator() {
		list = new ArrayList<Colleague>();
	}
	@Override
	public void registerColleague(Colleague c) {
		list.add(c);
	}

	@Override
	public void deliverMess(String mess, String... person) {
		Colleague c;
		for(int i=0;i<person.length;i++){
			for(int j=0;j<list.size();j++){
				c = list.get(j);
				if(c.getName().equals(person[i])){
					c.receiverMess(mess);
				}
			}
		}
	}
}
