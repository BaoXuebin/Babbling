package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import service.Box;
import utils.ImageUtils;
import utils.IntegerValue;

public class MainPanel extends JPanel implements MouseListener,ActionListener{
	
	private static final long serialVersionUID = 1L;
	public ArrayList<Box> boxGroup = new ArrayList<Box>();
	private JButton btnReplay = null;

	public MainPanel(String url) {
		boxGroup.clear();
		ImageUtils.setUrl(url);
		IntegerValue.margin = 3;
		initView();
	}

	private void initView() {
		setLayout(null);
		
		btnReplay = new JButton("Then");
		btnReplay.setBounds(IntegerValue.PANEL_POS_X + (IntegerValue.PANEL_WIDTH - 80)/2, IntegerValue.PANEL_HEIGHT + 100, 80, 40);
		btnReplay.setBackground(Color.white);
		btnReplay.setVisible(false);
		btnReplay.addActionListener(this);
		this.add(btnReplay);
		
		for (int i=0;i<IntegerValue.count_X; i++) {
			for (int j=0; j<IntegerValue.count_Y; j++) {
				new Box(this, i, j);
			}
		}
		
		for (Box box: boxGroup) {
			box.getOtherBox();
		}
		
	}
	
	public void addBox (Box box) {
		boxGroup.add(box);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for (Box box : boxGroup) {
			if (e.getSource() == box) {
				box.setBorder(BorderFactory.createLineBorder(Color.red));
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for (Box box : boxGroup) {
			if (e.getSource() == box) {
				box.setBorder(BorderFactory.createLineBorder(Color.black));
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (Box box : boxGroup) {
			if (e.getSource() == box) {
				box.setStatus(!box.isStatus());
				box.click2Change();
				if (box.getLeftBox() != null) {
					box.getLeftBox().setStatus(!box.getLeftBox().isStatus());
					box.getLeftBox().click2Change();
				}
				if (box.getRightBox() != null) {
					box.getRightBox().setStatus(!box.getRightBox().isStatus());
					box.getRightBox().click2Change();
				}
				if (box.getUpBox() != null) {
					box.getUpBox().setStatus(!box.getUpBox().isStatus());
					box.getUpBox().click2Change();
				}
				if (box.getDownBox() != null) {
					box.getDownBox().setStatus(!box.getDownBox().isStatus());
					box.getDownBox().click2Change();
				}
				
				// 判断是否完成游戏
				if(isComplete()){
					new Thread (new MyThread(this)).start();
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void Complete() {
		IntegerValue.PANEL_POS_Y = IntegerValue.PANEL_POS_Y - 1;
		
		for (Box box : boxGroup) {
			box.refresh();
		}
	}
	
	public void addButton () {
		btnReplay.setVisible(true);
	}
	
	private boolean isComplete() {
		for (Box box : boxGroup) {
			if (!box.isStatus()){
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReplay ){
			System.out.println("dddd");
			MainFrame.getInstance().changeMap();
		}
	}
}
