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
		floor = Toolkit.getDefaultToolkit().getImage("img\\floor\\floor3.png");//����
		floor4 = Toolkit.getDefaultToolkit().getImage("img\\floor\\floor2.png");//����
		appletree0 = Toolkit.getDefaultToolkit().getImage("img\\tree\\AppleTree0.png");//�й�ʵ��ƻ����
		appletree1 = Toolkit.getDefaultToolkit().getImage("img\\tree\\AppleTree1.png");//û�й�ʵ��ƻ����
		mogu = Toolkit.getDefaultToolkit().getImage("img\\mogu.png");//Ģ��
		altar = Toolkit.getDefaultToolkit().getImage("img\\altar.png");//��̳
		plant5 = Toolkit.getDefaultToolkit().getImage("img\\plant\\wheat0.png");//С������
		plant6 = Toolkit.getDefaultToolkit().getImage("img\\plant\\wheat2.png");//С��
		plant7 = Toolkit.getDefaultToolkit().getImage("img\\plant\\wheat3.png");//С��
	}
	public void drawImage(Graphics g,JPanel panel){
		int[][] tem = Map.map;
		for(int i=0;i<19;i++){
			for(int j=0;j<15;j++){
				g.drawImage(floor, 32*i, 32*j,(ImageObserver)panel);
				if(tem[i][j]==-1)
					g.drawImage(altar, 32*i, 32*j,(ImageObserver)panel);
				if(tem[i][j]==1)//����
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
