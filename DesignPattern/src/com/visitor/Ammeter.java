package com.visitor;

public class Ammeter extends AmmeterElement {
	double electricAmount;
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		double cost = v.visit(this);
		System.out.println("��ǰ�����û�����ɵ�ѣ�"+cost+"Ԫ");
	}

	@Override
	public void setElectricAmount(double n) {
		// TODO Auto-generated method stub
		electricAmount = n;
	}

	@Override
	public double showElectricAmount() {
		// TODO Auto-generated method stub
		return electricAmount;
	}

}
