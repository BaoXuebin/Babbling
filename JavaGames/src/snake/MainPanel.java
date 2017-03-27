package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class MainPanel extends JPanel implements ActionListener,KeyListener{
	private static final long serialVersionUID = 1L;
	Food food;
	Snake snake;
	static boolean GameStart = false;
	static boolean GameOver = true;
	static int Score,MaxScore,MyTime,Level=1;
	public static JButton bStart,bPause,bOver;
	public static JTextField fMaxScore,fPreScore,fTime,fLevel;
	JLabel lMaxScore,lPreScore,lTime,lLevel;
	JDialog dialog; 
	public MainPanel(){
		food = new Food();
		food.initFood();
		System.out.println(food.getFood_posX()+" "+food.getFood_posY());
		snake = new Snake();
		Snake.getSnake();
		
		setLayout(null);
		
		lMaxScore = new JLabel("最高分");
		lMaxScore.setBounds(400+25,100,60,20);
		add(lMaxScore);
		fMaxScore = new JTextField("0");
		fMaxScore.setBounds(400+15,125,60,20);
		fMaxScore.setEditable(false);
		fMaxScore.setHorizontalAlignment(JTextField.CENTER);
		add(fMaxScore);
		lPreScore = new JLabel("当前分");
		lPreScore.setBounds(400+25,150,60,20);
		add(lPreScore);
		fPreScore = new JTextField("0");
		fPreScore.setBounds(400+15,175,60,20);
		fPreScore.setEditable(false);
		fPreScore.setHorizontalAlignment(JTextField.CENTER);
		add(fPreScore);
		lTime = new JLabel("时间");
		lTime.setBounds(400+30,200,60,20);
		add(lTime);
		fTime = new JTextField("0");
		fTime.setBounds(400+15,225,60,20);
		fTime.setEditable(false);
		fTime.setHorizontalAlignment(JTextField.CENTER);
		add(fTime);
		
		lLevel = new JLabel("等级");
		lLevel.setBounds(400+30,250,60,20);
		add(lLevel);
		fLevel = new JTextField("1");
		fLevel.setBounds(400+15,275,60,20);
		fLevel.setEditable(false);
		fLevel.setHorizontalAlignment(JTextField.CENTER);
		add(fLevel);
		bStart = new JButton("开始");
		bStart.setBounds(400+20, 20, 60, 20);
		add(bStart);
		bStart.addActionListener(this);
		bPause = new JButton("暂停");
		bPause.setBounds(400+20, 50, 60, 20);
		add(bPause);
		bPause.addActionListener(this);
		bOver = new JButton("结束");
		bOver.setBounds(400+20, 340, 60, 20);
		add(bOver);
		bOver.addActionListener(this);
		addKeyListener(this);
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(400, 0, 400,400);
		g.drawLine(400, 90,500, 90);
		g.drawLine(400, 330,500, 330);
		g.drawRect(0, 0, 400, 370);
		g.drawRect(30, 25, 340, 320);
		if(GameStart)
			bStart.setEnabled(false);
		else
			bStart.setEnabled(true);
		if(GameOver)
			bPause.setEnabled(false);
		else
			bPause.setEnabled(true);
		drawFood(g);
		drawSnake(g);
		this.repaint();
	}
	/////画蛇
	void drawSnake(Graphics g){
		g.setColor(Color.blue);
		for(int i=0;i<Snake.length;i++){
			g.fillRect(Snake.SnakeBody[i][0], Snake.SnakeBody[i][1], Snake.size, Snake.size);
		}
	}
	/////画食物
	void drawFood(Graphics g){
		g.setColor(Color.red);
		g.fillOval(food.getFood_posX(), food.getFood_posY(), Snake.size, Snake.size);
		g.drawOval(food.getFood_posX(), food.getFood_posY(), Snake.size, Snake.size);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bStart){
			System.out.println("游戏开始");
			GameStart = true;
			GameOver = false;
			new Mythread();
			requestFocus(false);
		}
		else if(e.getSource()==bPause){
			System.out.println("游戏暂停");
			GameStart = false;
			GameOver = true;
			JOptionPane.showMessageDialog(this, "游戏暂停！","游戏",JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			System.out.println("游戏结束");
			System.exit(1);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(GameStart == true){
			switch(e.getKeyCode()){
			case KeyEvent.VK_DOWN:
				if(!Snake.direction.equals("up")){
					Snake.direction = "down";
				    System.out.println("向下走");
				}
				break;
			case KeyEvent.VK_UP:
				if(!Snake.direction.equals("down")){
					System.out.println("向上走");
					Snake.direction = "up";
				}	
				break;
			case KeyEvent.VK_LEFT:
				if(!Snake.direction.equals("right")){
					System.out.println("向左走");
					Snake.direction = "left";
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(!Snake.direction.equals("left")){
					System.out.println("向右走");
					Snake.direction = "right";
				}
				break;
			}
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
	public void getPanel(){
		if(snake.isEatFood()){
			Level = (Snake.length-3)/5+1;
			Score = Score + Level*10;
		}
	}
	public void showPanel(){
		int h,m,s;
		h = MyTime/3600;
		m = (MyTime%3600)/60;
		s = (MyTime%3600)%60;
		getPanel();
		String StrHour,StrMin,StrSec;
		StrHour = h +"";
		StrMin = m + "";
		StrSec = s + "";
		String StrScore = Score + "";
		String StrMaxScore = MaxScore + "";
		String StrLevel = Level + "";
		fMaxScore.setText(StrMaxScore);
		fPreScore.setText(StrScore);
		fTime.setText(StrHour+":"+StrMin+":"+StrSec);
		fLevel.setText(StrLevel);	
	}

}
