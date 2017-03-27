package com.testcollision;


import java.awt.Color;
import java.awt.Graphics;


public class Round implements Polygon {
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	private int r;
	private int x=400,y=250;
	private int xx,yy;
	private int pos;
	MainPanel panel;
	public Round(MainPanel panel) {
		initRound();
		this.panel = panel;
		panel.addObject(this);
	}
	public void initRound(){
		int i = (int)(Math.random()*4+1);
		int j = (int)(Math.random()*4+1);
		i=(int)(Math.pow(-1, i));
		j=(int)(Math.pow(-1, j));
		int value_x = (int)(Math.random()*5+1);//1到5
		int value_y = (int)(Math.random()*5+1);
		this.xx = i*value_x;
		this.yy = j*value_y;
		this.r = (int)(Math.random()*30+10);
	}
	@Override
	public void drawImage(Graphics g){
		g.setColor(Color.pink);
		if(collision())
			g.fillOval(x, y, r, r);
		else
			g.drawOval(x, y, r, r);
	}

	@Override
	public void update() {
		if(x<=0 || x>=800-r){ //撞到左边框,上一个状态为不被撞
			xx = -xx;
		}
		if(y<=0 || y>=500-r){
			yy = -yy;
		}
		if(x>=-50&&x<=800/2-2*r){
			if(y>=0&&y<500/2-2*r)
				pos = 1;
			else
				pos = 4;
		}else{
			if(y>=0&&y<500/2-2*r)
				pos = 2;
			else
				pos = 3;
		}
		x = x + xx;
		y = y + yy;	
	}
	public boolean collision(){//圆形间的碰撞检测
		for(int i=0;i<MainPanel.moveObjectList.size();i++){
			Round round = (Round) MainPanel.moveObjectList.get(i);
			if(pos == round.getPos()){
				int x1 = round.getX();
				int y1 = round.getY();
				int r1 = round.getR();
				int tem1 = x+r/2-x1-r1/2;
				int tem2 = y+r/2-y1-r1/2;
				int d = (int) Math.sqrt(tem1*tem1+tem2*tem2);
				if(d<=(r1+r)/2 && d!=0){
//					xx = -xx;
//					yy = -yy;	
					return true;
				}
			}
		}
		return false;
	}
}
