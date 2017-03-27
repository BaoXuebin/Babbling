package com.flyweightPattern;

public class Car {
	Flyweight flyweight;
	String color;
	int power;
	public Car(Flyweight flyweight,String color,int power) {
		this.color = color;
		this.flyweight = flyweight;
		this.power = power;
	}
	public void print(){
		System.out.print("��ɫ"+color);
		System.out.print("����"+power);
		System.out.print("���"+flyweight.getWidth());
		System.out.print("�߶�"+flyweight.getHeight());
		System.out.print("����"+flyweight.getLength());
	}
}
