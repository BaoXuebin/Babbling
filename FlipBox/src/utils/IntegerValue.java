package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public abstract class IntegerValue {
	
	private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static final int SCREEN_WIDTH = dim.width;
	
	public static final int SCREEN_HEIGHT = dim.height;
	
	public static final int FRAME_WIDTH = dim.width; //422
	
	public static final int FRAME_HEIGHT= dim.height; //445
	
	public static final int BOX_WIDTH = 120;
	public static final int BOX_HEIGHT = 120;
	
	public static int count_X = 4;
	public static int count_Y = 4;
	
	public static int margin = 3;
	
	public static int PANEL_WIDTH = (BOX_WIDTH + margin)* count_X;
	public static int PANEL_HEIGHT = (BOX_HEIGHT + margin) * count_Y;
	
	public static int PANEL_POS_X = (FRAME_WIDTH - PANEL_WIDTH ) /2 ;
	public static int PANEL_POS_Y = (FRAME_HEIGHT - PANEL_HEIGHT ) /2 ;
	
}
