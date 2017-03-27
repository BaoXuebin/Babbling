package game.panel;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

import bombpeople.*;

public class GamePanel extends JPanel implements Runnable,KeyListener{

	private static final long serialVersionUID = 1L;
	private Role role;
	private Floor floor;
	private Bomb bomb;
	MoveObject dog;
	MoveObject spider;
	Map map;
	ArrayList<MoveObject> moveObjectList;
	BagPanel bag;
	public GamePanel() {
		moveObjectList = new ArrayList<MoveObject>();
		role = new Role();
		floor = new Floor();
		map = new Map();
		bomb = new Bomb();
		bomb.init(1000, 1000);
		Thread t = new Thread(this);
		t.start();
		addKeyListener(this);
	}
	public void addObject(MoveObject moveObject){
		moveObjectList.add(moveObject);
	}
	public void deleteObject(){
		int i = moveObjectList.size();
		if(i>=1)
			moveObjectList.remove(i-1);
	}
	@Override
	public void run() {
		int i=0;
		while(true){
			i++;
			notMove();
			for(int j=0;j<moveObjectList.size();j++){
				MoveObject m = moveObjectList.get(j);
				m.notMove();
			}
			role.updateRoleImage();
			for(int j=0;j<moveObjectList.size();j++){
				MoveObject m = moveObjectList.get(j);
				m.updateRoleImage();
			}
			try{
				Thread.sleep(30);
			}catch(InterruptedException e){}
			if(i%3==0){
				repaint();
			}
			if(i%100==0){ //每3秒怪物改变一次方向
				for(int j=0;j<moveObjectList.size();j++){
					MoveObject m = moveObjectList.get(j);
					int dir = m.changeDir();
					m.setDirection(dir);
				}
			}
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		floor.drawImage(g, this);
		if(bomb.isPut()){
			bomb.drawImage(g, this);
			for(int j=0;j<moveObjectList.size();j++){
				MoveObject m = moveObjectList.get(j);
				m.drawImage(g, this);
			}
			role.drawImage(g, this);
		}else if(bomb.isExplosion()){
			role.drawImage(g, this);
			for(int j=0;j<moveObjectList.size();j++){
				MoveObject m = moveObjectList.get(j);
				m.drawImage(g, this);
			}
			bomb.drawEffectImage(g, this);
		}else{
			role.drawImage(g, this);
			for(int j=0;j<moveObjectList.size();j++){
				MoveObject m = moveObjectList.get(j);
				m.drawImage(g, this);
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			role.setDirection(0);
			role.setControl(true);
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			role.setDirection(1);
			role.setControl(true);
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			role.setDirection(2);
			role.setControl(true);
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			role.setDirection(3);
			role.setControl(true);
			break;
		case KeyEvent.VK_F:
			bomb = new Bomb(); 
			bomb.setPut(true);
			int bombX = (bomb.getBomb_posX()+4)/32;
	  		int bombY = (bomb.getBomb_posY()+4)/32;
			Map.map[bombX][bombY] = 100;
			break;
		case KeyEvent.VK_X:
			dog = new MonsterDog(this, 576, 416);
			break;
		case KeyEvent.VK_Z:
			spider = new MonsterSpider(this, 576, 416);
			break;
		case KeyEvent.VK_C:
			deleteObject();
			break;
		case KeyEvent.VK_E:
			role.plant();
			break;
		default:
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		role.setControl(false);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
		case KeyEvent.VK_Q:
			System.out.println("按space");
			break;
		default:
			break;
		}
	}
	public void notMove(){
		int roleX = role.getRole_posX();
		int roleY = role.getRole_posY();
		System.out.println(roleX+" "+roleY);
		int dir = role.getDirection();//方向
		int[][] tem = Map.map;
		boolean tag = false; //是否退出双循环的标记
		if(roleX<=0 && dir==2 || //判断是否撞墙
		   roleX>=576 && dir==3 ||
		   roleY<=0 && dir==0 ||
		   roleY>=416 && dir==1){
			role.setMove(false);
			System.out.println(role.isMove()+"fjfhja");
		}else{
			for(int i=0;i<19;i++){
				for(int j=0;j<15;j++){
					if(tem[i][j]==1||tem[i][j]==3||tem[i][j]==2){//遍历for循环，找到有树的位置
						////////////向上走////////////////
						if(dir==0){
							if(roleX>32*(i-1)+10&&roleX<32*(i+1)-10&&roleY>32*(j-1)&&roleY<=32*(j+1)){//不能行走
								role.setMove(false);
								tag = true;
								break;
							}else if(roleX>=32*(i-1)-10&&roleX<=32*(i-1)+10&&tem[i-1][j]==0){//
								role.setRole_posX(32*(i-1));
								role.setMove(true);
								break;
							}else if(roleX>=32*(i+1)-10&&roleX<=32*(i+1)+10&&tem[i+1][j]==0){
								role.setRole_posX(32*(i+1));
								role.setMove(true);
								break;
							}
							else{
								role.setMove(true);
							}
						}
						////////////向下走////////////////
						if(dir==1){
							if(roleX>32*(i-1)+10&&roleX<32*(i+1)-10&&roleY>=32*(j-1)&&roleY<32*(j+1)){//不能行走
								role.setMove(false);
								tag = true;
								break;
							}else if(roleX>=32*(i-1)-10&&roleX<=32*(i-1)+10&&tem[i-1][j]==0){//
								role.setRole_posX(32*(i-1));
								role.setMove(true);
								break;
							}else if(roleX>=32*(i+1)-10&&roleX<=32*(i+1)+10&&tem[i+1][j]==0){
								role.setRole_posX(32*(i+1));
								role.setMove(true);
								break;
							}
							else{
								role.setMove(true);
							}
						}
						/////////////向左走///////////////
						if(dir==2){
							if(roleY>32*(j-1)+10&&roleY<32*(j+1)-10&&roleX>32*(i-1)&&roleX<=32*(i+1)){//不能行走
								role.setMove(false);
								tag = true;
								break;
							}else if(roleY>=32*(j-1)-10&&roleY<=32*(j-1)+10&&tem[i][j-1]==0){//
								role.setRole_posY(32*(j-1));
								role.setMove(true);
								break;
							}else if(roleY>=32*(j+1)-10&&roleY<=32*(j+1)+10&&tem[i][j+1]==0){
								role.setRole_posY(32*(j+1));
								role.setMove(true);
								break;
							}
							else{
								role.setMove(true);
							}
						}
						/////////////向右走///////////////
						if(dir==3){
							if(roleY>32*(j-1)+10&&roleY<32*(j+1)-10&&roleX>=32*(i-1)&&roleX<32*(i+1)){//不能行走
								role.setMove(false);
								tag = true;
								break;
							}else if(roleY>=32*(j-1)-10&&roleY<=32*(j-1)+10&&tem[i][j-1]==0){//
								role.setRole_posY(32*(j-1));
								role.setMove(true);
								break;
							}else if(roleY>=32*(j+1)-10&&roleY<=32*(j+1)+10&&tem[i][j+1]==0){
								role.setRole_posY(32*(j+1));
								role.setMove(true);
								break;
							}
							else{
								role.setMove(true);
							}
						}
					}
			}
			if(tag)
				break;
		}
	}
	}
	
}
