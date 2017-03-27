package bombpeople;

import game.panel.GamePanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class MonsterSpider extends MoveObjects implements MoveObject {
	private Image pic0[] = null;//向上的图片数组
	private Image pic1[] = null;//向下的图片数组
	private Image pic2[] = null;//向左的图片数组
	private Image pic3[] = null;//向右的图片数组
	private Image tem[] = null;
	private int rPlayID = 1;//定义图片的id
	GamePanel game;
	public MonsterSpider(GamePanel gamePanel,int x,int y) {
		this.game = gamePanel;
		gamePanel.addObject(this);
		this.posX = x;
		this.posY = y;
		tem = new Image[4];
		pic1 = new Image[4];
		pic0 = new Image[4];
		pic2 = new Image[4];
		pic3 = new Image[4];
		for(int i=0;i<4;i++){
			pic0[i] = Toolkit.getDefaultToolkit().getImage("img\\monster\\spider\\spider_up"+i+".png");
			pic1[i] = Toolkit.getDefaultToolkit().getImage("img\\monster\\spider\\spider_down"+i+".png");
			pic2[i] = Toolkit.getDefaultToolkit().getImage("img\\monster\\spider\\spider_left"+i+".png");
			pic3[i] = Toolkit.getDefaultToolkit().getImage("img\\monster\\spider\\spider_right"+i+".png");
		}
	}
	@Override
	public void drawImage(Graphics g, JPanel panel) {
		super.drawImage(g, panel);
		if(direction==0){
			tem = pic0;
		}else if(direction==1){
			tem = pic1;
		}else if(direction==2){
			tem = pic2;
		}else if(direction==3){
			tem = pic3;
		}
		g.drawImage(tem[rPlayID], posX, posY,(ImageObserver)panel);
		if(move)
		    rPlayID++;
		else
			rPlayID = 1;
		if(rPlayID==4)
			rPlayID = 0;
	}
}
