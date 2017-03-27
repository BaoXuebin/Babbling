package com.testcollision;

import java.awt.Graphics;


public interface Polygon { //多边形接口
	public abstract void drawImage(Graphics g);
	public abstract void update();
	public abstract boolean collision();
//	public abstract int getX();
//	public abstract int getY();
}
