package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TetrisPanel extends JPanel implements ActionListener,KeyListener{
	private static final long serialVersionUID = 1L;
	public static boolean GameStart = false;
	public static boolean GameOver = false;
	JButton bStart,bPause,bOver;
	private String strButton[] ={"开始","重来","暂停","结束"}; 
	public TetrisPanel(){
		Block.getBlockData();
		setLayout(null);
		
		bStart = new JButton();
		bStart.setBounds(330,130, 70, 25);
		add(bStart);
		bStart.addActionListener(this);
		
		bPause = new JButton(strButton[2]);
		bPause.setBounds(330,165, 70, 25);
		add(bPause);
		bPause.addActionListener(this);
		
		bOver = new JButton(strButton[3]);
		bOver.setBounds(330,540, 70, 25);
		add(bOver);
		bOver.addActionListener(this);
		addKeyListener(this);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(GameStart){
			bStart.setText(strButton[1]);
		}
		else{
			bStart.setText(strButton[0]);
		}
		g.drawRect(5, 5, Block.BlockSize*10, Block.BlockSize*19);   // 10*19
		g.drawRect(315, 10, 100, 100); // 
		g.drawRect(315, 120, 100, 80);
		g.drawRect(315, 210, 100, 300);
		g.drawRect(315, 530, 100, 45);
		drawBlock(g);
		
		this.repaint();
	}
	
	

	private void drawBlock(Graphics g) {
		int i,j;
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				g.drawRect(Block.BlockposX, Block.BlockposY, Block.BlockSize*4, Block.BlockSize*4);
			}
		}
		for(j=0;j<16;j++){// 画移动方块
			if(Data.MoveBlock[Block.BlockShape][Block.BlockStatus][j]==1){
				int x = j%4;
				int y = j/4;
				g.setColor(Color.blue);
				g.drawRoundRect(Block.BlockposX + Block.BlockSize*x, Block.BlockposY + Block.BlockSize*y, 
						Block.BlockSize, Block.BlockSize, 7, 7);
			}
		}
		for(i=0;i<10;i++){// 画背景方块
			for(j=0;j<19;j++){
				if(Block.BackBlock[i][j]!=0){
					g.setColor(Color.BLUE);
					g.fillRoundRect(5 + i*Block.BlockSize, 5 + j*Block.BlockSize, 
							Block.BlockSize, Block.BlockSize, 7, 7);
				}
			}	
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bOver){
			System.out.println("游戏结束");
			System.exit(1);		
		}
		else if(e.getSource()==bPause){
			GameStart = false;
			System.out.println("游戏暂停");
		}
		else if(e.getActionCommand().equals(strButton[0])){
			GameStart = true;
			new MyThread();
			System.out.println("游戏开始");
			requestFocus(true);	///
		}
		else{
			requestFocus(true);
			newGame();
		}
		
	}

	public void newGame() {
		Block.BlockposX = 95;
		Block.BlockposY = 5;
		Block.getBlockData();
		System.out.println("新游戏");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(GameStart){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				Block.moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				Block.moveRight();
				break;	
			case KeyEvent.VK_UP:
				Block.blockShift();
				break;
			case KeyEvent.VK_DOWN:
				Block.speedUp();
				break;	
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			Block.speedDown();//正常速度下降
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
