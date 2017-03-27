package snake;



public class Mythread implements Runnable{
	MainPanel mainPanel;
	Snake snake;
	EndDialog endDialog;
	public Mythread(){
		snake = new Snake();
		mainPanel = new MainPanel();
		endDialog = new EndDialog();
		mainPanel.getPanel();
		Thread t = new Thread(this);
		//启动线程
		t.start();
	}

	@Override
	public void run() {
		int i=0;
		while(MainPanel.GameStart){
			try {
				Thread.sleep(50);
			} catch (Exception e) {
			}
			i++;
			int temlevel = ((10-MainPanel.Level)*60)/50;
			if(i%temlevel==0 && MainPanel.GameStart){
				mainPanel.showPanel();
				snake.eatFood();
				snake.move();
			}
			if(i%20==0){
				MainPanel.MyTime++;
			}
			endDialog.showDialog();
		}
		if(MainPanel.GameStart){
			System.out.println("游戏开始lll");
		}
	}
}
