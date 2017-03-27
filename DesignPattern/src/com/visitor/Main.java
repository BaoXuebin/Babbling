package com.visitor;

public class Main {
	public static void main(String[] args) {
		Visitor visit1 = new HomeAmmeterVisitor();
		Visitor visit2 = new IndustryAmmeterVisitor();
		Ammeter ammeter = new Ammeter();
		ammeter.setElectricAmount(5678);
		ammeter.accept(visit1);
	}

}
