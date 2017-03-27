package com.decorator;

public class SparrowDecorator extends Decorator {
	public final int DISTANCE = 50;
	public SparrowDecorator(Bird bird) {
		super(bird);
	}
	@Override
	public int elseFly() {
		// TODO Auto-generated method stub
		return DISTANCE;
	}
	@Override
	public int fly() {
		int distance = 0;
		distance = bird.fly()+elseFly();
		return distance;
	}

}
