package service;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.MainPanel;
import utils.ImageUtils;
import utils.IntegerValue;

public class Box extends JLabel {

	private static final long serialVersionUID = 1L;
	/**
	 * 位置，状态，
	 */
	private MainPanel panel = null;
	private boolean status = false;
	private int pos_X = 0;
	private int pos_Y = 0;
	private Box upBox = null;
	private Box downBox = null;
	private Box leftBox = null;
	private Box rightBox = null;
	private boolean tag = false;
	
	public Box() {
	}

	public Box(MainPanel panel, int x, int y) {
		this.panel = panel;
		this.pos_X = x;
		this.pos_Y = y;
		
		initView();
		
		panel.addBox(this);
		this.addMouseListener(panel);
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public int getPos_X() {
		return pos_X;
	}

	public void setPos_X(int posX) {
		pos_X = posX;
	}

	public int getPos_Y() {
		return pos_Y;
	}

	public void setPos_Y(int posY) {
		pos_Y = posY;
	}

	private void initView() {
		this.setLocation(IntegerValue.PANEL_POS_X + pos_X*(IntegerValue.BOX_WIDTH+IntegerValue.margin) + IntegerValue.margin, 
				IntegerValue.PANEL_POS_Y + pos_Y*(IntegerValue.BOX_HEIGHT+IntegerValue.margin) + IntegerValue.margin);
		this.setSize(IntegerValue.BOX_WIDTH, IntegerValue.BOX_HEIGHT);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
//		ImageIcon icon = new ImageIcon("res/images/test.jpg");
//		icon.setImage(icon.getImage().getScaledInstance(this.getSize().width,this.getSize().height, Image.SCALE_AREA_AVERAGING));
//		this.setIcon(icon);
		panel.add(this);
	}
	
	public void getOtherBox () {
		if (panel.boxGroup.size() != IntegerValue.count_X*IntegerValue.count_Y) {
			return;
		}
		//初始化左方块
		if ( pos_X-1 >= 0) {
			leftBox = panel.boxGroup.get((pos_X-1)*IntegerValue.count_Y + pos_Y);
		}
		//初始化右方块
		if ( pos_X+1 < IntegerValue.count_X) {
			rightBox = panel.boxGroup.get((pos_X+1)*IntegerValue.count_Y + pos_Y);
		}
		//初始化上方块
		if ( pos_Y-1 >= 0) {
			upBox = panel.boxGroup.get(pos_X*IntegerValue.count_Y + pos_Y - 1);
		}
		//初始化下方块
		if ( pos_Y+1 < IntegerValue.count_Y) {
			downBox = panel.boxGroup.get(pos_X*IntegerValue.count_Y + pos_Y + 1);
		}
	}

	public Box getUpBox() {
		return upBox;
	}

	public void setUpBox(Box upBox) {
		this.upBox = upBox;
	}

	public Box getDownBox() {
		return downBox;
	}

	public void setDownBox(Box downBox) {
		this.downBox = downBox;
	}

	public Box getLeftBox() {
		return leftBox;
	}

	public void setLeftBox(Box leftBox) {
		this.leftBox = leftBox;
	}

	public Box getRightBox() {
		return rightBox;
	}

	public void setRightBox(Box rightBox) {
		this.rightBox = rightBox;
	}
	
	public void click2Change () {
		if (status) {
			ImageIcon icon = ImageUtils.cutImage(pos_X, pos_Y);
			this.setIcon(icon);
		} else {
			this.setIcon(null);
		}
	}
	
	public void refresh() {
		if (!tag) {
			tag = true;
			this.setBorder(null);
			this.removeMouseListener(panel);
		}
		
		if (IntegerValue.margin > 0) {
			IntegerValue.margin = IntegerValue.margin - 1;
		}
		
		this.setLocation(IntegerValue.PANEL_POS_X + pos_X*(IntegerValue.BOX_WIDTH+IntegerValue.margin) + IntegerValue.margin, 
				IntegerValue.PANEL_POS_Y + pos_Y*(IntegerValue.BOX_HEIGHT+IntegerValue.margin) + IntegerValue.margin);
	}
	
	
	
	

}
