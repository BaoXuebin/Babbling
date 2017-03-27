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
		System.out.print("颜色"+color);
		System.out.print("功率"+power);
		System.out.print("宽度"+flyweight.getWidth());
		System.out.print("高度"+flyweight.getHeight());
		System.out.print("长度"+flyweight.getLength());
	}
}
