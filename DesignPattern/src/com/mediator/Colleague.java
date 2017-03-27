package com.mediator;

public interface Colleague {
	public void giveMess(String mess,String ...person);
	public void receiverMess(String mess);
	public void setName(String s);
	public String getName();
	public void setMediator(Mediator mediator);
}
