package com.decorator;

public abstract class Decorator extends Bird {
	Bird bird;
	public Decorator() {
		// TODO Auto-generated constructor stub
	}
	public Decorator(Bird bird){
		this.bird = bird;
	}
	public abstract int elseFly();
}
