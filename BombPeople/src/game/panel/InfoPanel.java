package game.panel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InfoPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	JLabel imgLabel;
	ImageIcon imgIcon,bagImgIcon,skillImgIcon;
	JLabel bagLabel,skillLabel;
	public InfoPanel() {
		initButton();
		setBackground(Color.lightGray);
		setLayout(null);
		imgLabel = new JLabel();
		imgIcon = new ImageIcon("img\\img0.png");
		imgLabel.setBounds(20, 20, 60, 60);
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imgLabel.setIcon(imgIcon);
	}
	public void initButton(){
		bagLabel = new JLabel();
		skillLabel = new JLabel();
		bagImgIcon = new ImageIcon("img\\bag.jpg");
		skillImgIcon = new ImageIcon("img\\skill.jpg");
		bagLabel.setBounds(10, 10, 40, 40);
		bagLabel.setIcon(bagImgIcon);
		skillLabel.setIcon(skillImgIcon);
		skillLabel.setBounds(10, 60, 40, 40);
		add(bagLabel);
		add(skillLabel);
	}
	

}
