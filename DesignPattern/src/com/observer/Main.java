package com.observer;

public class Main {
	public static void main(String[] args) {
		Subject center = new SeekJobCenter();
		Observer zhang = new UniversityStudent(center, "zhang.txt");
		Observer wang = new HaiGui(center, "wang.txt");
		center.giveNewMess("IBM��Ҫjava����Ա");
		center.notifyObservers();
		center.giveNewMess("������ѧ��Ҫͼ��ݹ���Ա");
		center.notifyObservers();
		center.giveNewMess("��Ϊ��Ҫ�������ʦԱ");
		center.notifyObservers();
		center.giveNewMess("��Ϊ��Ҫ�������ʦԱ");
		center.notifyObservers();
	}

}
