package sliderpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener,KeyListener,MouseListener{
	private static final long serialVersionUID = 1L;
	private BlockButton[] button = new BlockButton[9];
	private BlockButton blankButton = null;
	public GamePanel(){
		setLayout(null);
		JButton bStart = new JButton("开始");
		bStart.setBounds(0,0, 70, 25);
		add(bStart);
		bStart.addActionListener(this);
		init();
		startGame();
	}
    public void init(){
    	BlockButton blockButton=null;
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
    			int num = 3*i+j+1;
    			ImageIcon img = new ImageIcon("picture"+num+".jpg");
    			blockButton = new BlockButton(img, num-1);
    			blockButton.setLocation(20+j*BlockButton.LENGTH, 30+i*BlockButton.LENGTH);
    			button[num-1]=blockButton;
    		}
    	}
    	for(int i=0;i<button.length;i++){
    		this.add(button[i]);
    	}
    }
    public void startGame(){
    	Random rand = new Random();
    	int m,n,x,y;

    	if(blankButton==null){
    		blankButton = button[button.length-1];
    		for(int i=0;i<button.length;i++){
    			if(i!=button.length-1)
    				button[i].addMouseListener(this);
    		}
    	}
    	for(int i=0;i<button.length;i++){  
    		m = rand.nextInt(button.length);
    		n = rand.nextInt(button.length);
    		x = button[m].getX();
    		y = button[m].getY();
    		button[m].setLocation(button[n].getX(),button[n].getY());
    		button[n].setLocation(x, y);	
    	}
    	System.out.println(button.length);
    }
    private boolean isSuccess(){
    	for(int i=0;i<button.length;i++){
    		int x = button[i].getX();
    		int y = button[i].getY();
    		if(x/BlockButton.LENGTH*3+y/BlockButton.LENGTH != button[i].getPosition())
    			return false;
    	}
		return true;
    	
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("开始")){
			//button.setLocation(150, 20);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		BlockButton blockButton = (BlockButton)e.getSource();
		int x = blankButton.getX();
		int y = blankButton.getY();
		String str[]={"UP","DOWN","LEFT","RIGHT"};
		if(x-blockButton.getX()==BlockButton.LENGTH &&
				y==blockButton.getY()){ //右
			blockButton.move(str[3]);
			blankButton.move(str[2]);
		}else if(blockButton.getX()-x==BlockButton.LENGTH &&
				y==blockButton.getY()){ //左
			blockButton.move(str[2]);
			blankButton.move(str[3]);
		}else if(blockButton.getX()==x &&
				y-blockButton.getY()==BlockButton.LENGTH){ //下
			blockButton.move(str[1]);
			blankButton.move(str[0]);
		}else if(blockButton.getX()==x &&
				blockButton.getY()-y==BlockButton.LENGTH){ //上
			blockButton.move(str[0]);
			blankButton.move(str[1]);
		}
		if(isSuccess()){
			JOptionPane.showMessageDialog(this,"游戏完成",
					"OK",JOptionPane.OK_OPTION);
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
