package ui;

import java.awt.Container;

import javax.swing.JFrame;

import utils.IntegerValue;
import utils.StringValue;

/**
 * 程序的 入口，采用单例模式实现
 *
 * @author BaoXuebin
 *
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static MainFrame mf = null;
	private MainPanel mp = null;
	private Container c;
	private String[] urls = {"test.jpg","test1.jpg","test2.jpg","test3.jpg","test4.jpg",};
	private int index = 0;
	
	private MainFrame(){
		mp = new MainPanel(urls[index]);
		c = this.getContentPane();
		c.add(mp);
		
		initView();
	}
	
	// 初始化视图
	public void initView(){
		this.setTitle(StringValue.TITLE);
		this.setSize(IntegerValue.FRAME_WIDTH, IntegerValue.FRAME_HEIGHT);
		
		int pos_X = (IntegerValue.SCREEN_WIDTH - this.getSize().width)/2;
		int pos_Y = (IntegerValue.SCREEN_HEIGHT - this.getSize().height)/2;
		
		this.setLocation(pos_X, pos_Y);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setUndecorated(true);
		this.setVisible(true);
	}
	
	public void changeMap () {
		c.remove(mp);
		IntegerValue.PANEL_POS_Y = (IntegerValue.FRAME_HEIGHT - IntegerValue.PANEL_HEIGHT ) / 2;
		if ( ++index >= urls.length) {
			this.dispose();
		}else {
			mp = new MainPanel(urls[index]);
			c.add(mp);
			this.setVisible(true);
		}
	}
	
	public static MainFrame getInstance(){
		if (mf == null) {
			mf = new MainFrame();
		}
		return mf;
	}
	
	
	public static void main(String[] args) {
		getInstance();
	}

}
