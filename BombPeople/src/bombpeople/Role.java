package bombpeople;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;

public class Role{
	private static int role_posX = 0,role_posY = 0;//����������������
	private int roleX = 0,roleY = 0;
	private Image pic0[] = null;//���ϵ�ͼƬ����
	private Image pic1[] = null;//���µ�ͼƬ����
	private Image pic2[] = null;//�����ͼƬ����
	private Image pic3[] = null;//���ҵ�ͼƬ����
	private Image tem[] = null;
	private int rPlayID = 1;//����ͼƬ��id
	private int direction = 1;//0��    1��    2��    3��
	private boolean control = false;
	private boolean move = true;
	ObjectGrow objectGrow;
	public Role() {
		tem = new Image[4];
		pic1 = new Image[4];
		pic0 = new Image[4];
		pic2 = new Image[4];
		pic3 = new Image[4];
		for(int i=0;i<4;i++){
			pic0[i] = Toolkit.getDefaultToolkit().getImage("img\\role\\role_back"+i+".png");
			pic1[i] = Toolkit.getDefaultToolkit().getImage("img\\role\\play"+i+".png");
			pic2[i] = Toolkit.getDefaultToolkit().getImage("img\\role\\role_left"+i+".png");
			pic3[i] = Toolkit.getDefaultToolkit().getImage("img\\role\\role_right"+i+".png");
		}
	}
	public int getRoleX() { //��ȡ����x����
		return roleX;
	}
	public void setRoleX(int roleX) {
		this.roleX = roleX;
	}
	public int getRoleY() {//��ȡ����y����
		return roleY;
	}
	public void setRoleY(int roleY) {
		this.roleY = roleY;
	}
	public int getRole_posX() {
		return role_posX;
	}

	public void setRole_posX(int rolePosX) {
		role_posX = rolePosX;
	}

	public int getRole_posY() {
		return role_posY;
	}

	public void setRole_posY(int rolePosY) {
		role_posY = rolePosY;
	}
	public boolean isMove() {
		return move;
	}
	public void setMove(boolean move) {
		this.move = move;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public boolean isControl() {
		return control;
	}
	public void setControl(boolean control) {
		this.control = control;
	}
	public void init(int x,int y){
		role_posX = x;
		role_posY = y;
	}
	public void drawImage(Graphics g,JPanel panel){
		if(direction==0){
			tem = pic0;
		}else if(direction==1){
			tem = pic1;
		}else if(direction==2){
			tem = pic2;
		}else if(direction==3){
			tem = pic3;
		}
		g.drawImage(tem[rPlayID], role_posX, role_posY,(ImageObserver)panel);
		if(control)
		    rPlayID++;
		else
			rPlayID = 1;
		if(rPlayID==4)
			rPlayID = 0;
	} 
	
	public void updateRoleImage(){
		if(control&&move){
			if(direction==0){
				role_posY -= 2;
			}else if(direction==1){
				role_posY += 2;
			}else if(direction==2){
				role_posX -= 2;
			}else if(direction==3){
				role_posX += 2;
			}
		}
		if(direction==0){
			roleX = (role_posX+16)/32;
			if((role_posY+16)/32-1>=0){
				roleY = (role_posY+16)/32-1;
			}
		}else if(direction==1){
			roleX = (role_posX+16)/32;
			if((role_posY+16)/32+1<=14)
				roleY = (role_posY+16)/32+1;
		}else if(direction==2){
			if((role_posX+16)/32-1>=0)
				roleX = (role_posX+16)/32-1;
			roleY = (role_posY+16)/32;
		}else if(direction==3){
			if((role_posX+16)/32+1<=18)
				roleX = (role_posX+16)/32+1;
			roleY = (role_posY+16)/32;
		}
	}
	public void plant(){
		if(Map.map[roleX][roleY]==0){
			Map.map[roleX][roleY]=4;
			System.out.println("��������");
		}
		else if(Map.map[roleX][roleY]==1){
			Map.map[roleX][roleY]=3;
			System.out.println("�ջ�ƻ��");
		}
		else if(Map.map[roleX][roleY]==4){//����������С������
			Map.map[roleX][roleY]=5;
			objectGrow = new ObjectGrow(120,6,roleX,roleY);
			objectGrow = new ObjectGrow(240,7,roleX,roleY);
			System.out.println("��������");
		}else if(Map.map[roleX][roleY]==7){
			Map.map[roleX][roleY]=0;
			System.out.println("�ջ��ʵ10");
		}
	}
	public void collect(){
		
	}
	public void technique(){ //����
		
	}

}
