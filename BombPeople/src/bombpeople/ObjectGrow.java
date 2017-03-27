package bombpeople;

public class ObjectGrow implements Runnable {
	public boolean isFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	Thread t;
	int time = 0; 
	int change = 0;
	int x,y;
	boolean finish = false;
	public ObjectGrow(int time,int changeId,int posX,int posY) {
		this.x = posX;
		this.y = posY;
		this.time = time;
		this.change = changeId;
		t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		int count = 0;
		while(true){
			count++;
			if(count>time){
				update(x, y);
				break;
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public void update(int x,int y){
		Map.map[x][y] = change;
	}
}
