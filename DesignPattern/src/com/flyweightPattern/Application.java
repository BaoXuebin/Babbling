package com.flyweightPattern;

public class Application {
	public static void main(String[] args) {
		FlyweightFactory factory = FlyweightFactory.getFactory();
		Flyweight carIntrinsic = factory.getFlyweight();
		Car car1 = new Car(carIntrinsic,"ºÚÉ«",128);
		car1.print();
	}

}
