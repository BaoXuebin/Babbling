package snake;


public class Snake {
	Food food;
	public static int length=3;
	public static int size = 20;
	public static String direction ="right";
	public static int[][] SnakeBody = new int[200][2];
	public Snake(){
		food = new Food();
	}
	public static void getSnake(){
		SnakeBody[0][0] = 70;
		SnakeBody[0][1] = 25;
		
		SnakeBody[1][0] = 50;
		SnakeBody[1][1] = 25;
		
		SnakeBody[2][0] = 30;
		SnakeBody[2][1] = 25;
	}
	public void eatFood(){
		if(isEatFood()){
			System.out.println("³Ôµ½Ê³Îï");
			length = length + 1;
			food.initFood();
		}
	}
	public void move(){
		for(int i=length-1;i>0;i--){
			SnakeBody[i][0] = SnakeBody[i-1][0];
			SnakeBody[i][1] = SnakeBody[i-1][1];
		}
		if(direction.equals("right")){
			SnakeBody[0][0] += Snake.size;
		}
		else if(direction.equals("left")){
			SnakeBody[0][0] -= Snake.size;
		}
		else if(direction.equals("up")){
			SnakeBody[0][1] -= Snake.size;
		}
		else{
			SnakeBody[0][1] += Snake.size;
		}
	}
	public boolean isEatFood(){
		if(SnakeBody[0][0]==food.getFood_posX() && SnakeBody[0][1]==food.getFood_posY())
			return true;
		else
		    return false;
	}
	public boolean isDead(){
		if(SnakeBody[0][0]<30 || SnakeBody[0][0]>350 || SnakeBody[0][1]<25 || SnakeBody[0][1]>325){
			MainPanel.GameStart = false;
			return true;
			}
		else if(isEatBody()){
			MainPanel.GameStart = false;
			return true;
		}	
		else 
			return false;
	}
	private boolean isEatBody() {
		for(int i=1;i<length;i++){
			if(SnakeBody[i][0]==SnakeBody[0][0] && SnakeBody[i][1]==SnakeBody[0][1])
				return true;
		}
		return false;
	}
}
