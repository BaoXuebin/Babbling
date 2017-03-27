package com.observer;

public interface Subject {
	public void addObserver(Observer o);
	public void deleteObserver(Observer o);
	public void notifyObservers();
	public void giveNewMess(String str);
}
