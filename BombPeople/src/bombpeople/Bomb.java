package bombpeople;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.FileInputStream;

import javax.swing.JPanel;

public class Bomb implements Runnable{
	FileInputStream file;
	Thread t;
	Image bomb;
	private Image[] effect = null;
	Role role;
	private boolean put = false;
	private boolean explosion = false;//爆炸
	private boolean begin = false;//true炸弹被放置
	private int ePlayId = 0;
	private int time = 0;
	private int bomb_posX = 0,bomb_posY = 0;
	
	public boolean isExplosion() {
		return explosion;
	}
	public void setExplosion(boolean explosion) {
		this.explosion = explosion;
	}
	public int getBomb_posX() {
		return bomb_posX;
	}
	public void setBomb_posX(int bombPosX) {
		bomb_posX = bombPosX;
	}
	public int getBomb_posY() {
		return bomb_posY;
	}
	public void setBomb_posY(int bombPosY) {
		bomb_posY = bombPosY;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public boolean isPut() {
		return put;
	}
	public void setPut(boolean put) {
		this.put = put;
	}
	public boolean isBegin() {
		return begin;
	}
	public void setBegin(boolean begin) {
		this.begin = begin;
	}
	public Bomb() { //构造方法
		effect = new Image[6];
		for(int i=0;i<6;i++){
			effect[i] = Toolkit.getDefaultToolkit().getImage("img\\skill\\skill"+i+".png");
		}
		bomb = Toolkit.getDefaultToolkit().getImage("img\\bomb.png");
		role = new Role();
		bomb_posX = (role.getRole_posX()+16)/32*32+4;
		bomb_posY = (role.getRole_posY()+16)/32*32+4;
		t = new Thread(this);
		t.start();
	}
	public void init(int x,int y){
		bomb_posX = x;
		bomb_posY = y;
	}
	public void drawImage(Graphics g,JPanel panel){
		g.drawImage(bomb, bomb_posX, bomb_posY,(ImageObserver)panel);
	}
	public void drawEffectImage(Graphics g,JPanel panel){
		g.drawImage(effect[ePlayId], bomb_posX-32, bomb_posY-32, (ImageObserver)panel);
		if(explosion){
			ePlayId++;
			if(ePlayId>5){
				ePlayId = 5;
			}
		}
	}
  	@Override
	public void run() {
		int count = 0;
		while(true){
			count++;
			if(count>=10&&count<11){ //count等于10炸弹爆炸
				put = false;
				explosion = true;
			}else if(count==11){
				damage(bomb_posX,bomb_posY);
			}else if(count>11){
				put = false;
				explosion = false;
				if((bomb_posX+4)/32>=0&&(bomb_posX+4)/32<=18&&(bomb_posY+4)/32>=0&&(bomb_posY+4)/32<=14)
					Map.map[(bomb_posX+4)/32][(bomb_posY+4)/32] = 0;
				break;
			}
			try {
				Thread.sleep(250);
			} catch (InterruptedException e){
				// TODO: handle exception
			}
		}
	}
  	private void damage(int x,int y){
  		int bombX = (x+4)/32;
  		int bombY = (y+4)/32;
  		if(bombY-1>=0&&bombY-1<=14)
  			Map.map[bombX][bombY-1] = 0;
  		if(bombY+1>=0&&bombY+1<=14)
  			Map.map[bombX][bombY+1] = 0;
  		if(bombX-1>=0&&bombX-1<=18)
  			Map.map[bombX-1][bombY] = 0;
  		if(bombX+1>=0&&bombX+1<=18)
  			Map.map[bombX+1][bombY] = 0;
  	}
}
