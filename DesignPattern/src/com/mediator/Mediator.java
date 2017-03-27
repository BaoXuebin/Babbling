package com.mediator;

public interface Mediator {
	public void registerColleague(Colleague c);
	public void deliverMess(String mess,String ...person);
}
