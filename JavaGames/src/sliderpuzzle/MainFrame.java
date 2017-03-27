package sliderpuzzle;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public MainFrame(){}  //���캯��
	public void startGame(){
		GamePanel p = new GamePanel();
		Container c = this.getContentPane();
		c.add(p);
		setTitle("SliderPuzzle");
		setVisible(true);//���ڿɼ�
		setResizable(false);//���ܵ������ڴ�С
		setSize(500,545);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		setBounds(x,y,w,h);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.startGame();
	}
}
