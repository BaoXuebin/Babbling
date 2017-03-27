package com.observer;

public class Main {
	public static void main(String[] args) {
		Subject center = new SeekJobCenter();
		Observer zhang = new UniversityStudent(center, "zhang.txt");
		Observer wang = new HaiGui(center, "wang.txt");
		center.giveNewMess("IBM需要java程序员");
		center.notifyObservers();
		center.giveNewMess("北京大学需要图书馆管理员");
		center.notifyObservers();
		center.giveNewMess("华为需要软件工程师员");
		center.notifyObservers();
		center.giveNewMess("华为需要软件工程师员");
		center.notifyObservers();
	}

}
