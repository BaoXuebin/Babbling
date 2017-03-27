package com.flyweightPattern;

public class FlyweightFactory {
	static FlyweightFactory factory = new FlyweightFactory();
	static Flyweight intrinsic;
	private FlyweightFactory(){
		
	}
	public static FlyweightFactory getFactory(){
		return factory;
	}
	public Flyweight getFlyweight(){
		intrinsic = new CarData(1.82,1.45,5.12);
		return intrinsic;
	}
}
