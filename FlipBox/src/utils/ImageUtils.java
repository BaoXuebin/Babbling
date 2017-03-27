package utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;

import javax.swing.ImageIcon;

public class ImageUtils {
	
	private static String url = "test.jpg";
	
	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		ImageUtils.url = url;
	}


	public static ImageIcon cutImage (int x, int y) {
		//设置图片的大小
		ImageIcon icon = null;
		Image image = Toolkit.getDefaultToolkit().createImage("res/images/" + url);
		image = image.getScaledInstance(IntegerValue.BOX_WIDTH*IntegerValue.count_X, 
				IntegerValue.BOX_HEIGHT*IntegerValue.count_Y, Image.SCALE_DEFAULT);
		
		Image croppedImage;
		ImageFilter cropFilter;
		cropFilter = new CropImageFilter(x*IntegerValue.BOX_WIDTH, y*IntegerValue.BOX_HEIGHT, 
				IntegerValue.BOX_WIDTH, IntegerValue.BOX_HEIGHT);
		croppedImage = Toolkit.getDefaultToolkit().
						createImage(new FilteredImageSource(image.getSource(), cropFilter));
		
		icon = new ImageIcon(croppedImage);
		
		return icon;
	}
	
}
