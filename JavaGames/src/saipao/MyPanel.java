package saipao;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import start.Start;

public class MyPanel extends JPanel implements ActionListener,Runnable{

	private static final long serialVersionUID = 1L;
	JButton start,reset,btnMenu;
	Cavalry_1 c1;
	Cavalry_2 c2;
	public MyPanel() {
		c1 = new Cavalry_1(10,100);
		c2 = new Cavalry_2(10, 200);
		initLayout();
	}
	
	private void initLayout() {
		// TODO Auto-generated method stub
		this.setLayout(null);
		start = new JButton("开始");
		start.setBounds(50,20,60,30);
		start.addActionListener(this);
		this.add(start);
		
		reset = new JButton("重置");
		reset.setBounds(130,20,60,30);
		reset.addActionListener(this);
		this.add(reset);
		
		btnMenu = new JButton("主菜单");
		btnMenu.setBounds(210,20,100,30);
		btnMenu.addActionListener(this);
		this.add(btnMenu);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		c1.drawImage(g, this);
		c2.drawImage(g, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(start)){
			System.out.println("开始");
			Thread t = new Thread(this);
			t.start();
		}else if(e.getSource().equals(reset)){
			System.out.println("重置");
			c1.setPos_X(10);
			c2.setPos_X(10);
			repaint();
		}else if(e.getSource().equals(btnMenu)){
			MyFrame.getInstance().setVisible(false);
			Start.getInstance().setVisible(true);
		}
	}

	@Override
	public void run() {
		int count=0;
		while(true){
			count ++;
			if(count%3 == 0)
				repaint();
			c1.update();
			c2.update();
			if(c1.getPos_X() > 500){
				System.out.println("1号胜");
				break;
			}
			if(c2.getPos_X() > 500){
				System.out.println("2号胜");
				break;
			}
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
