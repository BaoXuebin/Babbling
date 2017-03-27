package ui;

import utils.IntegerValue;

public class MyThread implements Runnable {
	
	private MainPanel panel;
	
	public MyThread(MainPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				panel.Complete();
				Thread.sleep(30);
				if (IntegerValue.PANEL_POS_Y <= 50) {
					panel.addButton();
					break;
				}			
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
