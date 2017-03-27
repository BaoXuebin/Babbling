package bombpeople;

import java.awt.Graphics;
import javax.swing.JPanel;

public interface MoveObject {
	public void drawImage(Graphics g,JPanel panel);
	public void updateRoleImage();
	public void notMove();
	public int changeDir();
	public void setDirection(int dir);
}
