package bombpeople;

import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class MoveObjects {
	protected boolean move = true;
	protected int posX = 0;
	protected int posY = 0;
	protected int direction = 1;
	Role role; 
	public MoveObjects() {
		// TODO Auto-generated constructor stub
		direction = (int)(Math.random()*4);
		role = new Role();
	}
	public void drawImage(Graphics g,JPanel panel){};
	public void updateRoleImage(){
		if(move){
			if(direction==0){
				posY -= 2;
			}else if(direction==1){
				posY += 2;
			}else if(direction==2){
				posX -= 2;
			}else if(direction==3){
				posX += 2;
			}
		}
	};
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public boolean isMove() {
		return move;
	}
	public void setMove(boolean move) {
		this.move = move;
	}
	public void notMove(){
		int[][] tem = Map.map;
		boolean tag = false; //是否退出双循环的标记
		
		if(posX<=0 && direction==2 || //判断是否撞墙
				posX>=576 && direction==3 ||
				posY<=0 && direction==0 ||
				posY>=416 && direction==1){
			setMove(false);
			direction = changeDir();
		}else{
			for(int i=0;i<19;i++){
				for(int j=0;j<15;j++){
					if(tem[i][j]>0){//遍历for循环，找到有树的位置
						////////////向上走////////////////
						if(direction==0){
							if(posX>32*(i-1)+10&&posX<32*(i+1)-10&&posY>32*(j-1)&&posY<=32*(j+1)){//不能行走
								setMove(false);
								direction = changeDir();
								tag = true;
								break;
							}else if(posX>=32*(i-1)-10&&posX<=32*(i-1)+10&&tem[i-1][j]==0){//
								setPosX(32*(i-1));
								setMove(true);
								break;
							}else if(posX>=32*(i+1)-10&&posX<=32*(i+1)+10&&tem[i+1][j]==0){
								setPosX(32*(i+1));
								setMove(true);
								break;
							}
							else{
								setMove(true);
							}
						}
						////////////向下走////////////////
						if(direction==1){
							if(posX>32*(i-1)+10&&posX<32*(i+1)-10&&posY>=32*(j-1)&&posY<32*(j+1)){//不能行走
								setMove(false);
								direction = changeDir();
								tag = true;
								break;
							}else if(posX>=32*(i-1)-10&&posX<=32*(i-1)+10&&tem[i-1][j]==0){//
								setPosX(32*(i-1));
								setMove(true);
								break;
							}else if(posX>=32*(i+1)-10&&posX<=32*(i+1)+10&&tem[i+1][j]==0){
								setPosX(32*(i+1));
								setMove(true);
								break;
							}
							else{
								setMove(true);
							}
						}
						/////////////向左走///////////////
						if(direction==2){
							if(posY>32*(j-1)+10&&posY<32*(j+1)-10&&posX>32*(i-1)&&posX<=32*(i+1)){//不能行走
								setMove(false);
								direction = changeDir();
								tag = true;
								break;
							}else if(posY>=32*(j-1)-10&&posY<=32*(j-1)+10&&tem[i][j-1]==0){//
								setPosY(32*(j-1));
								setMove(true);
								break;
							}else if(posY>=32*(j+1)-10&&posY<=32*(j+1)+10&&tem[i][j+1]==0){
								setPosY(32*(j+1));
								setMove(true);
								break;
							}
							else{
								setMove(true);
							}
						}
						/////////////向右走///////////////
						if(direction==3){
							if(posY>32*(j-1)+10&&posY<32*(j+1)-10&&posX>=32*(i-1)&&posX<32*(i+1)){//不能行走
								setMove(false);
								direction = changeDir();
								tag = true;
								break;
							}else if(posY>=32*(j-1)-10&&posY<=32*(j-1)+10&&tem[i][j-1]==0){//
								setPosY(32*(j-1));
								setMove(true);
								break;
							}else if(posY>=32*(j+1)-10&&posY<=32*(j+1)+10&&tem[i][j+1]==0){
								setPosY(32*(j+1));
								setMove(true);
								break;
							}
							else{
								setMove(true);
							}
						}
					}
				}
			if(tag)
				break;
			}
		}
	}
	public int changeDir(){
		int x = role.getRole_posX();//获得此刻人物的x值
		int y = role.getRole_posY();//获得此刻人物的y值
		int distanceX = Math.abs(x-posX);
		int distanceY = Math.abs(y-posY);
		int dir = 0;
		if(move==true){
			if(distanceX<=distanceY){//向上或向下
				if(posY<=y)
					dir = 1;
				else
					dir = 0;
			}else{
				if(posX<=x)
					dir = 3;
				else
					dir = 2;
			}
//			if(posX<x){
//				if(distanceX<=distanceY)
//					dir = 0;
//				else
//					dir = 3;
//			}else if(posX>x){
//				if(distanceX<=distanceY)
//					dir = 0;
//				else
//					dir = 2;
//			}else if(posY<y){
//				if(distanceX<=distanceY)
//					dir = 1;
//				else
//					dir = 3;
//			}else if(posY>y){
//				if(distanceX<=distanceY)
//					dir = 1;
//				else
//					dir = 2;
//			}
		}
		else{
			dir = (int)(Math.random()*4);
		}
		return dir;
	}
}
