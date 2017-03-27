package game.panel;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	private GamePanel game;
	private InfoPanel info;
	public GameFrame() {
//		this.setFocusable(true);
		this.setLayout(null);
		game = new GamePanel();
		info = new InfoPanel();
		game.setLocation(5, 5);
		game.setSize(608, 450);
		game.setFocusable(true);
		info.setLocation(5, 458);
		info.setSize(608, 120);
		this.add(game);
		this.add(info);
		setTitle("我的世界");
		setVisible(true);//窗口可见
		setResizable(false);//不能调整窗口大小
		setSize(623,600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		setBounds(x,y,w,h);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
	}
	public static void main(String[] args) {
		new GameFrame();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			game.setVisible(false);
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
