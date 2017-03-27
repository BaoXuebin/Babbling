package saipao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class Cavalry_1{
	public int getPos_X() {
		return pos_X;
	}
	public void setPos_X(int posX) {
		pos_X = posX;
	}
	public int getPos_Y() {
		return pos_Y;
	}
	public void setPos_Y(int posY) {
		pos_Y = posY;
	}
	private Image[] horse = new Image[4];
	private int rID;
	private int pos_X;
	private int pos_Y;
	
	public Cavalry_1(int x,int y) {
		this.pos_X = x;
		this.pos_Y = y;
		horse[0] = Toolkit.getDefaultToolkit().getImage("horse\\horse1_1.png");
		horse[1] = Toolkit.getDefaultToolkit().getImage("horse\\horse1_2.png");
		horse[2] = Toolkit.getDefaultToolkit().getImage("horse\\horse1_3.png");
		horse[3] = Toolkit.getDefaultToolkit().getImage("horse\\horse1_4.png");
	}
	public void drawImage(Graphics g,JPanel panel){
		g.drawImage(horse[rID],pos_X,pos_Y,(ImageObserver)panel);
		rID ++;
		if(rID>3){
			rID = 0;
		}
	}
	public void update(){
		int rand = (int)(Math.random()*5);
		pos_X = pos_X + rand; 
	}
	
}
