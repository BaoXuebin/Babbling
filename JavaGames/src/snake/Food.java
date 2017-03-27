package snake;

import java.util.Random;

public class Food {
	private int food_posX,food_posY;
	Random r ;
	public Food() {
		r = new Random();
	}
	public void initFood(){
		food_posX = Math.abs((r.nextInt())%17)*20+30;
		food_posY = Math.abs((r.nextInt())%16)*20+25;
		for(int i=0;i<Snake.length;i++){
			if(Snake.SnakeBody[i][0]==food_posX && Snake.SnakeBody[i][1]==food_posY){
				food_posX = Math.abs((r.nextInt())%17)*20+30;
				food_posY = Math.abs((r.nextInt())%16)*20+25;
			}
		}
	}
	public void setFood_posX(int foodPosX) {
		food_posX = foodPosX;
	}
	public void setFood_posY(int foodPosY) {
		food_posY = foodPosY;
	}
	public int getFood_posX() {
		return food_posX;
	}
	public int getFood_posY() {
		return food_posY;
	}

	//	public static int food_posX,food_posY;
//	private static Random r = new Random();
//	
//	public Food() {
//	}
//	
//	public static void newFood(){
//		food_posX = Math.abs((r.nextInt())%17)*20+30;
//		food_posY = Math.abs((r.nextInt())%16)*20+25;
//		for(int i=0;i<Snake.length;i++){
//			if(Snake.SnakeBody[i][0]==food_posX && Snake.SnakeBody[i][1]==food_posY){
//				food_posX = Math.abs((r.nextInt())%17)*20+30;
//				food_posY = Math.abs((r.nextInt())%16)*20+25;
//			}
//		}
//	}
	
	
}
