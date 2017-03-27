package com.testcollision;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	public static ArrayList<Polygon> moveObjectList;
	public  static boolean pause = false;
	public MainPanel() {
		moveObjectList = new ArrayList<Polygon>();
		this.setLocation(10, 10);
		this.setSize(800, 502);
		this.setBackground(Color.black);
		Thread t = new Thread(this);
		t.start();
	}
	
	public void addObject(Polygon moveObject){
		moveObjectList.add(moveObject);
	}
	public void deleteObject(int i){
		moveObjectList.remove(i);
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.drawLine(400, 0, 400, 500);
		g.drawLine(0, 250, 800, 250);
		for(int j=0;j<moveObjectList.size();j++){
			Polygon p = moveObjectList.get(j);
			p.drawImage(g);
		}
	}
	@Override
	public void run() {
		int i = 0;
		while(true){
			i++;
			if(!pause){
				for(int j=0;j<moveObjectList.size();j++){
					Polygon p = moveObjectList.get(j);
//					p.collision();
					p.update();
//					Rectangular rect = (Rectangular)p;
//					int x1 = rect.getX();
//					int y1 = rect.getY();
//					int x2 = rect.getX()-rect.getWidth();
//					int y2 = rect.getY();
//					int x3 = rect.getX()+rect.getWidth();
//					int y3 = rect.getY()+rect.getHeight();
//					int x4 = rect.getX();
//					int y4 = rect.getY()+rect.getHeight();
//					int[][] polygon2 = {{x1,y1},{x2,y2},{x3,y3},{x4,y4},{x1,y1}};
//					System.out.println(x1+","+y1+" "+x2+","+y2+" "+x3+","+y3+" "+x4+","+y4);
				}
//				System.out.println("////");/
			}
			repaint();
			try {
				Thread.sleep(30);
			} catch (Exception e){
				// TODO: handle exception
			}
//			
		}
		
	}
}
