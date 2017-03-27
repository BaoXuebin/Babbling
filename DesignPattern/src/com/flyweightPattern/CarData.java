package com.flyweightPattern;

public class CarData implements Flyweight {
	private double height;
	private double width;
	private double length;
	public CarData(double height,double width,double length) {
		this.height = height;
		this.length = length;
		this.width = width;
	}
	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public double getLength() {
		return length;
	}

	@Override
	public double getWidth() {
		return width;
	}

}
