package snake;

import java.awt.*;
import javax.swing.*;


public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	public Main(){
		Container c = this.getContentPane();
		c.add(new MainPanel());
		setTitle("̰����");
		setVisible(true);//���ڿɼ�
		setResizable(false);//���ܵ������ڴ�С
		setSize(400 +100,400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		setBounds(x,y,w,h);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	public static void main(String[] args){
		new Main();
	}
}
