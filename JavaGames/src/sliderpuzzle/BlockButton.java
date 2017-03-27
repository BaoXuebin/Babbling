package sliderpuzzle;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BlockButton extends JButton{
	private static final long serialVersionUID = 1L;
	public static int LENGTH = 150;
	private int position=0;
	public BlockButton(ImageIcon img,int position) {
		this.setSize(LENGTH, LENGTH);
		this.setIcon(img);
		this.position=position;
	}
	public int getX(){
		return this.getBounds().x;
	}
	public int getY(){
		return this.getBounds().y;
	}
	public int getPosition(){
		return position;
	}
	public void move(String str){
		Rectangle rec = this.getBounds();
		if(str.equals("UP")){
			this.setLocation(rec.x, rec.y-LENGTH);
		}else if(str.equals("DOWN")){
			this.setLocation(rec.x, rec.y+LENGTH);
		}else if(str.equals("LEFT")){
			this.setLocation(rec.x-LENGTH, rec.y);
		}else if(str.equals("RIGHT")){
			this.setLocation(rec.x+LENGTH, rec.y);
		}else{System.out.println("³öÏÖ´íÎó");}
	}

}
