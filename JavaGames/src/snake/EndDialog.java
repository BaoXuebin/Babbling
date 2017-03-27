package snake;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class EndDialog extends JDialog implements ActionListener{
	JButton bOk,bCancel;
	JLabel lScore,lMyTime;
	JTextField tScore,tMyTime;
	private static final long serialVersionUID = 1L;
	MainPanel mainPanel;
	Snake snake;
	public EndDialog(){
		mainPanel = new MainPanel();
		snake = new Snake();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bCancel)
		{
			MainPanel.GameStart = true;
			MainPanel.GameOver = true;
			dispose();
		}
		else{
			newGame();
			dispose();
		}
		
	}

	private void newGame() {
		MainPanel.MyTime = 0;
		MainPanel.Score = 0;
		mainPanel.showPanel();
		MainPanel.GameOver = true;
		MainPanel.Level = 1;
		Snake.length = 3;
		Snake.getSnake();
		Snake.direction = "right";
		new Mythread();
	}
	public void showDialog(){
		if(snake.isDead()){
			setLayout(null);
			lMyTime = new JLabel("时间：");
			lMyTime.setBounds(70, 40, 100, 20);
			add(lMyTime);
			tMyTime = new JTextField(20);
			tMyTime.setBounds(120, 40, 80, 20);
			tMyTime.setEditable(false);
			tMyTime.setHorizontalAlignment(JTextField.CENTER);
			String strTime = MainPanel.fTime.getText();
			tMyTime.setText(strTime);
			add(tMyTime);
			lScore = new JLabel("得分：");
			lScore.setBounds(70, 70, 80, 20);
			add(lScore);
			tScore = new JTextField(MainPanel.Score+"");
			tScore.setBounds(120, 70, 80, 20);
			tScore.setEditable(false);
			tScore.setHorizontalAlignment(JTextField.CENTER);
			add(tScore);
			
			bOk = new JButton("继续");
			bOk.setBounds(60, 130, 60, 20);
		    bOk.addActionListener(this);
			add(bOk);
			bCancel = new JButton("好吧");
			bCancel.setBounds(170, 130, 60, 20);
			bCancel.addActionListener(this);
			add(bCancel);
			
			 	
			
			setTitle("游戏结束");
			setVisible(true);//窗口可见
			setResizable(false);//不能调整窗口大小
			this.setModal(false);
			setSize(300,200);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			int w = this.getSize().width;
			int h = this.getSize().height;
			int x = (dim.width-w)/2;
			int y = (dim.height-h)/2;
			setBounds(x,y,w,h);
		}
	} 
	

}
