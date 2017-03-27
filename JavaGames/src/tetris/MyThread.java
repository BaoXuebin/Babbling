package tetris;


public class MyThread implements Runnable{
	public MyThread(){
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		int i=0;
		while(TetrisPanel.GameStart){
			try {
				Thread.sleep(50);
			} catch (Exception e) {
			}
			i++;
			Block.eliminate();
			if(i%5==0){
				Block.gameOver();
				Block.getBlockPos();
				Block.speedDown();
			}
		}
	}
}
