package bombpeople;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class Floor {
	Image floor,floor4;
	Image appletree0;
	Image appletree1;
	Image mogu,plant5,plant6,plant7;
	Image altar;
	public Floor() {
		floor = Toolkit.getDefaultToolkit().getImage("img\\floor\\floor3.png");//地面
		floor4 = Toolkit.getDefaultToolkit().getImage("img\\floor\\floor2.png");//土地
		appletree0 = Toolkit.getDefaultToolkit().getImage("img\\tree\\AppleTree0.png");//有果实的苹果树
		appletree1 = Toolkit.getDefaultToolkit().getImage("img\\tree\\AppleTree1.png");//没有果实的苹果树
		mogu = Toolkit.getDefaultToolkit().getImage("img\\mogu.png");//蘑菇
		altar = Toolkit.getDefaultToolkit().getImage("img\\altar.png");//祭坛
		plant5 = Toolkit.getDefaultToolkit().getImage("img\\plant\\wheat0.png");//小麦幼苗
		plant6 = Toolkit.getDefaultToolkit().getImage("img\\plant\\wheat2.png");//小麦
		plant7 = Toolkit.getDefaultToolkit().getImage("img\\plant\\wheat3.png");//小麦
	}
	public void drawImage(Graphics g,JPanel panel){
		int[][] tem = Map.map;
		for(int i=0;i<19;i++){
			for(int j=0;j<15;j++){
				g.drawImage(floor, 32*i, 32*j,(ImageObserver)panel);
				if(tem[i][j]==-1)
					g.drawImage(altar, 32*i, 32*j,(ImageObserver)panel);
				if(tem[i][j]==1)//果树
					g.drawImage(appletree0, 32*i, 32*j,(ImageObserver)panel);
				if(tem[i][j]==2)
					g.drawImage(mogu, 32*i, 32*j,(ImageObserver)panel);
				if(tem[i][j]==3)
					g.drawImage(appletree1, 32*i, 32*j,(ImageObserver)panel);
				if(tem[i][j]==4)
					g.drawImage(floor4, 32*i, 32*j,(ImageObserver)panel);
				if(tem[i][j]==5){
					g.drawImage(floor4, 32*i, 32*j,(ImageObserver)panel);
					g.drawImage(plant5, 32*i+8, 32*j+8,(ImageObserver)panel);
				}
				if(tem[i][j]==6){
					g.drawImage(floor4, 32*i, 32*j,(ImageObserver)panel);
					g.drawImage(plant6, 32*i, 32*j,(ImageObserver)panel);
				}
				if(tem[i][j]==7){
					g.drawImage(floor4, 32*i, 32*j,(ImageObserver)panel);
					g.drawImage(plant7, 32*i, 32*j,(ImageObserver)panel);
				}
					
			}
		}
	}
}
