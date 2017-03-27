package com.observer;

import java.util.ArrayList;

public class SeekJobCenter implements Subject {
	String mess;
	boolean changed;//ÊÇ·ñ¸Ä±ä
	ArrayList<Observer> personList;
	SeekJobCenter(){
		personList = new ArrayList<Observer>();
		mess = "";
		changed = false;
	}
	@Override
	public void addObserver(Observer o) {
		if(!(personList.contains(o))){
			personList.add(o);
		}
	}

	@Override
	public void deleteObserver(Observer o) {
		if(personList.contains(o)){
			personList.remove(o);
		}
	}

	@Override
	public void giveNewMess(String str) {
		if(str.equals(mess)){
			changed = false;
		}else{
			mess = str;
			changed = true;
		}
	}

	@Override
	public void notifyObservers() {
		if(changed){
			for(int i=0;i<personList.size();i++){
				Observer observer = personList.get(i);
				observer.hearTelephone(mess);
			}
			changed = false;
		}
	}

}
