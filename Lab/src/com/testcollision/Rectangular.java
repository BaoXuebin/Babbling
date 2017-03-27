package com.testcollision;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangular implements Polygon {
	
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
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	private int x = 350,y = 250;
	private int width,height;
	private int xx,yy;
	MainPanel panel;
	public Rectangular(MainPanel panel){
		initRect();
		this.panel = panel;
		panel.addObject(this);
	}
	public void initRect(){
		int i = (int)(Math.random()*4+1);
		int j = (int)(Math.random()*4+1);
		i=(int)(Math.pow(-1, i));
		j=(int)(Math.pow(-1, j));
		int value_x = (int)(Math.random()*5+1);//1到5
		int value_y = (int)(Math.random()*5+1);
		this.xx = i*value_x;
		this.yy = j*value_y;
		width = (int)(Math.random()*50+10);
		height = (int)(Math.random()*50+10);
//		width = 50;
//		height = 50;
	}
	@Override
	public void drawImage(Graphics g) {
		g.setColor(Color.pink);
		if(collision())
			g.fillRect(x, y, width, height);
		else 
			g.drawRect(x, y, width, height);
	}
	public boolean collision(){
		for(int i=0;i<MainPanel.moveObjectList.size();i++){
			Rectangular rect = (Rectangular) MainPanel.moveObjectList.get(i);
			int[][] polygon1 = {{x,y},{x+width,y},{x+width,y+height},{x,y+height},{x,y}};
			if(x==rect.getX()&&y==rect.getY()&&width==rect.getWidth()&&height==rect.getHeight())
				continue;
			int x1 = rect.getX();
			int y1 = rect.getY();
			int x2 = rect.getX()+rect.getWidth();
			int y2 = rect.getY();
			int x3 = rect.getX()+rect.getWidth();
			int y3 = rect.getY()+rect.getHeight();
			int x4 = rect.getX();
			int y4 = rect.getY()+rect.getHeight();
			int[][] polygon2 = {{x1,y1},{x2,y2},{x3,y3},{x4,y4},{x1,y1}};
			if(isCollision(polygon1, polygon2))
				return true;
		}
		return false;
	}
	@Override
	public void update() {
//		if(collision()){
//			xx = -xx;
//			yy = -yy;
//		}
		if(x<=0 || x>=800-width){ //撞到左边框
			xx = -xx;
		}
		if(y<=0 || y>=500-height){
			yy = -yy;
		}
		x = x + xx;
		y = y + yy;
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
}
