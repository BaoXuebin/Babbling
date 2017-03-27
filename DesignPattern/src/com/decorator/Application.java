package com.decorator;

public class Application {
	public static void main(String[] args) {
		Bird bird = new Sparrow();
		System.out.println("û�а�װ���ӳ���С����о��룺"+bird.fly());
		bird = new SparrowDecorator(bird);
		System.out.println("��װ1�����ӳ���С����о��룺"+bird.fly());
		bird = new SparrowDecorator(bird);
		System.out.println("��װ2�����ӳ���С����о��룺"+bird.fly());
		bird = new SparrowDecorator(bird);
		System.out.println("��װ3�����ӳ���С����о��룺"+bird.fly());
	}
}
