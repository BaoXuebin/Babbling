package com.decorator;

public class Application {
	public static void main(String[] args) {
		Bird bird = new Sparrow();
		System.out.println("没有安装电子翅膀的小鸟飞行距离："+bird.fly());
		bird = new SparrowDecorator(bird);
		System.out.println("安装1个电子翅膀的小鸟飞行距离："+bird.fly());
		bird = new SparrowDecorator(bird);
		System.out.println("安装2个电子翅膀的小鸟飞行距离："+bird.fly());
		bird = new SparrowDecorator(bird);
		System.out.println("安装3个电子翅膀的小鸟飞行距离："+bird.fly());
	}
}
