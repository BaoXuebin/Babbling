package start;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import saipao.MyFrame;
import sliderpuzzle.MainFrame;
import snake.Main;
import tetris.TetrisMain;
public class Start extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private static Start start = null;
	JButton bstart1,bstart2,bstart3,bstart4;
	
	private Start(){
		setLayout(null);
		
		bstart1 = new JButton("贪吃蛇");
		bstart1.setBounds(80, 30, 100, 30);
		add(bstart1);
		bstart1.addActionListener(this);
		
		bstart2 = new JButton("俄罗斯方块");
		bstart2.setBounds(80, 90, 100, 30);
		add(bstart2);
		bstart2.addActionListener(this);
		
		bstart3 = new JButton("九格拼图");
		bstart3.setBounds(80, 150, 100, 30);
		add(bstart3);
		bstart3.addActionListener(this);
		
		bstart4 = new JButton("赛马");
		bstart4.setBounds(80, 210, 100, 30);
		add(bstart4);
		bstart4.addActionListener(this);
		
		setTitle("JAVA游戏");
		setVisible(true);//窗口可见
		setResizable(false);//不能调整窗口大小
		setSize(300,400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		setBounds(x,y,w,h);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==bstart1){
			dispose();
			new Main();
		}else if(e.getSource()==bstart2){
			dispose();
			new TetrisMain();
		}else if(e.getSource()==bstart3){
			dispose();
			MainFrame mf = new MainFrame();
			mf.startGame();
		} else if (e.getSource()==bstart4) {
			setVisible(false);
			MyFrame.getInstance().setVisible(true);
		} 
	}
	
	public static Start getInstance () {
		if (start == null) {
			start = new Start();
		}
		
		return start;
	}
	public static void main(String[] args) {
		getInstance();
	}
}
