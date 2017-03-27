package saipao;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static MyFrame frame = null;
	
	private MyFrame() {
		Component c = new MyPanel();
		this.add(c);
		setTitle("赛马");
		setVisible(true);//窗口可见
//		setResizable(false);//不能调整窗口大小
		setSize(650,600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		setBounds(x,y,w,h);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static MyFrame getInstance() {
		if (frame == null) {
			frame = new MyFrame();
		}
		
		return frame;
	}
	
	public static void main(String[] args) {
		getInstance();
	}
}
