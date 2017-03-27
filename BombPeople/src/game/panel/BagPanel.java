package game.panel;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class BagPanel extends JPanel implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GamePanel game;
	public BagPanel() {
		this.setLocation(5, 5);
		this.setSize(400, 400);
		this.setBackground(Color.black);
		addKeyListener(this);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			game = new GamePanel();
			game.setFocusable(true);
			game.setVisible(true);
			this.setVisible(false);
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
