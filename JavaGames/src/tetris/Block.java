package tetris;

import java.util.Random;

public class Block {
	private static Random r = new Random();
	public static int temY,v;//计数
	public static int BlockSize = 30;
	public static int BlockposX = 95;
	public static int BlockposY = 5;
	public static int BlockShape;
	public static int BlockStatus;
	public static int[][] BackBlock = new int[10][19];
	public static int MinLeft,MaxRight, MinUp, MaxDown,RelposX,RelposY;
	static int[] Array = new int[4];
	public Block(){	
	}
	public static void getBlockData(){
		int i,j;
		BlockShape = Math.abs(r.nextInt()%7);
		BlockStatus = Math.abs(r.nextInt()%4);
		for(i=0;i<10;i++){
			for(j=0;j<19;j++){
				BackBlock[i][j] = 0;
			}	
		}
	}
	public static void newBlock(){
		BlockposX = 95;
		BlockposY = 5;
		BlockShape = Math.abs(r.nextInt()%7);
		BlockStatus = Math.abs(r.nextInt()%4);
	}
	public static void passValue(){//将方块的值传给背景
		int i;
		for(i=0;i<4;i++){
			BackBlock[RelposX+Array[i]%4][RelposY+Array[i]/4] = 1;
		}
	}
	public static void getBlockPos(){//获取方块的四周位置
		MinLeft=MinUp=MaxRight=MaxDown=1;
		int i,j=0;
		for(i=0;i<16;i++){
			if(Data.MoveBlock[BlockShape][BlockStatus][i]==1){
				Array[j] = i;
				j++;
		    }
		}
		for(i=0;i<4;i++){
			if(Array[i]%4==0) MinLeft=0;
			if(Array[i]/4==0) MinUp=0;
		}
		for(i=0;i<4;i++){
			if(Array[i]%4==3){
				MaxRight=3;
				break;
			}
			else if(Array[i]%4==2)
				MaxRight=2;
		}
		for(i=0;i<4;i++){
			if(Array[i]/4==3){
				MaxDown=3;
				break;
			}
			else if(Array[i]/4==2)
				MaxDown=2;
		}
		RelposX = (BlockposX-5)/BlockSize;
		RelposY = (BlockposY-5)/BlockSize;
	}
	public static boolean isLeftMove(){//判断是否可以向左移动
		if(BlockposX <= 5 - MinLeft*BlockSize)
			return false;	
		return true;	
	}
	public static boolean isRightMove(){//判断是否可以向右移动
		if(BlockposX >= 275 - MaxRight*BlockSize)
		    return false;
		return true;
	}
	public static void eliminate(){  // 消行
		int i,j,a=0;//a用来计数
		if(isEliminate()){
			for(i=temY;i>0;i--){
				for(j=0;j<10;j++){
					BackBlock[j][i] = BackBlock[j][i-1];		
				}
			}
			a++;
		}
		if(a==1)
			System.out.println("分数加100");
		else if(a==2)
			System.out.println("分数加200");
		else if(a==3)
			System.out.println("分数加300");
		else if(a==4)
			System.out.println("分数加400");
		
	}
	private static boolean isEliminate() {//判断消行
		int i,j,a;//a用来计数
		for(i=0;i<19;i++){
			a=0;
			for(j=0;j<10;j++){
				if(BackBlock[j][i]==0)
					break;
				else
					a++;
			}
			if(a==10){
				System.out.println("消行"+i);
				temY = i;
				return true;
			}
		}
		return false;	
	}
	public static void moveLeft(){
		if(isLeftMove()){
			BlockposX -= BlockSize;
			System.out.println("向左移动");
		}
	}
	public static void moveRight() {
		if(isRightMove()){
			BlockposX += BlockSize;
			System.out.println("向右移动");
		}
	}
	public static void blockShift() {
		if(isShift()){
			BlockStatus ++;
			if(BlockStatus == 4)
				BlockStatus = 0;
			System.out.println("变形");
		}
	}
	public static boolean isShift() {//判断是否可以旋转	
		return true;
	}
	public static void speedUp() {
		System.out.println("加速下降");
	}
	public static void speedDown() {
		if(isMoveDown()){
			BlockposY += BlockSize;
		}
		else{
			passValue();//传值
		    newBlock();//生成新方块
		}
	}
	private static boolean isMoveDown() {
		if(BlockposY > 515 - MaxDown*BlockSize || isCollide()){//越界
			return false;
		}
		else {
			//System.out.println(RelposY);
			return true;	
		}	
	}
	private static boolean isCollide() {//检验碰撞
		if(BackBlock[RelposX+Array[0]%4][RelposY+Array[0]/4+1]!=0 ||
		   BackBlock[RelposX+Array[1]%4][RelposY+Array[1]/4+1]!=0 ||
		   BackBlock[RelposX+Array[2]%4][RelposY+Array[2]/4+1]!=0 ||
		   BackBlock[RelposX+Array[3]%4][RelposY+Array[3]/4+1]!=0)
			return true;
		else
		    return false;
		
	}
	public static void gameOver() {
		if(isGameOver()){
			TetrisPanel.GameStart = false;
			System.out.println("game over");	
		}
	}
	private static boolean isGameOver(){
		int i;
		for(i=0;i<10;i++){
			if(BackBlock[i][0] != 0){
				return true;
			}
		}
		return false;
	}
}
