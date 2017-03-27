package com.testcollision;

import java.awt.Color;
import java.awt.Graphics;

public class Pentagon implements Polygon {
	public int[] getxPoints() {
		return xPoints;
	}
	public void setxPoints(int[] xPoints) {
		this.xPoints = xPoints;
	}
	public int[] getyPoints() {
		return yPoints;
	}
	public void setyPoints(int[] yPoints) {
		this.yPoints = yPoints;
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
	private int x = 350,y = 250;
	private int nPoints,WIDTH;
	private int xx,yy;
	MainPanel panel;
	private int[] xPoints = new int[6];
	private int[] yPoints = new int[6];
	public Pentagon(MainPanel panel) {
		initPenta();
		this.panel = panel;
		panel.addObject(this);
	}
	public void initPenta(){
		nPoints = 6;
		int i = (int)(Math.random()*4+1);
		int j = (int)(Math.random()*4+1);
		i=(int)(Math.pow(-1, i));
		j=(int)(Math.pow(-1, j));
		int value_x = (int)(Math.random()*5+1);//1到5
		int value_y = (int)(Math.random()*5+1);
		this.xx = i*value_x;
		this.yy = j*value_y;
		WIDTH = (int)(Math.random()*20+10);
		int[] xP = {x,x+WIDTH,x+2*WIDTH,x+2*WIDTH,x+WIDTH,x};
		int[] yP = {y-WIDTH,y,y-WIDTH,y-3*WIDTH,y-4*WIDTH,y-3*WIDTH};
		xPoints = xP;
		yPoints = yP;
		System.out.println(WIDTH);
	}
	@Override
	public boolean collision() {
		for(int i=0;i<MainPanel.moveObjectList.size();i++){
			Pentagon penta = (Pentagon) MainPanel.moveObjectList.get(i);
			int[][] polygon1 = {{xPoints[0],yPoints[0]},{xPoints[1],yPoints[1]},{xPoints[2],yPoints[2]},
					{xPoints[3],yPoints[3]},{xPoints[4],yPoints[4]},{xPoints[5],yPoints[5]},{xPoints[0],yPoints[0]}};
			if(x==penta.getX()&&y==penta.getY())
				continue;
			int[] x1 = penta.getxPoints();
			int[] y1 = penta.getyPoints();
			System.out.println(x1[0]+","+y1[0]+" "+x1[1]+","+y1[1]+" "+x1[2]+","+y1[2]+" "+x1[3]+","+y1[3]);
			int[][] polygon2 = {{x1[0],y1[0]},{x1[1],y1[1]},{x1[2],y1[2]},{x1[3],y1[3]},{x1[4],y1[4]},{x1[5],
				y1[5]},{x1[0],y1[0]}};
			if(isCollision(polygon1, polygon2))
				return true;
		}
		System.out.println("//////");
		return false;
	}

	@Override
	public void drawImage(Graphics g) {
		g.setColor(Color.pink);
		if(collision())
			g.fillPolygon(xPoints, yPoints, nPoints);
		else 
			g.drawPolygon(xPoints, yPoints, nPoints);
	}

	@Override
	public void update() {
		if(x<=0 || x>=800-2*WIDTH){ //撞到左边框
			xx = -xx;
		}
		if(y<=4*WIDTH || y>=500){
			yy = -yy;
		}
		x = x + xx;
		y = y + yy;
		int[] xP = {x,x+WIDTH,x+2*WIDTH,x+2*WIDTH,x+WIDTH,x};
		int[] yP = {y-WIDTH,y,y-WIDTH,y-3*WIDTH,y-4*WIDTH,y-3*WIDTH};
		xPoints = xP;
		yPoints = yP;
	}
	public boolean isCollision(int[][] polygon1,int[][] polygon2){//
		int max1=0,min1=0,max2=0,min2=0,count=0;
		for(int i=0;i<polygon1.length-1;i++){
			for(int j=0;j<polygon1.length-1;j++){
				int b = intercept(polygon1[i][0],polygon1[i][1],polygon1[i+1][0],polygon1[i+1][1],polygon1[j][0],polygon1[j][1]);
				if(b>max1||j==0)
					max1 = b;
				if(b<min1||j==0)
					min1 = b;
			}
			count = 0;
			for(int j=0;j<polygon2.length-1;j++){
				int b = intercept(polygon1[i][0],polygon1[i][1],polygon1[i+1][0],polygon1[i+1][1],polygon2[j][0],polygon2[j][1]);
				if(b>=min1&&b<=max1)
					break;
				else{
					if(b>max2||j==0)
						max2 = b;
					if(b<min2||j==0)
						min2 = b;
					count++;
				}
			}
			if(count>=polygon2.length-1&&!(max2>max1&&min2<min1)){
				return false;
			}
		}
		return true;
	}
	public int intercept(int x1,int y1,int x2,int y2,int x3,int y3){//求截距,坐标变换
		int b = 0;
		if(x1==x2){//斜率不存在
			b = x3;
		}else{
			int k = (y1-y2)/(x1-x2);
			b = y3-k*x3;
		}
		return b;
	}
}
