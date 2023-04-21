package ch12.sec11.exam;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class ResourceExample {
	public ResourceExample() {
		JFrame f = new JFrame("Image");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("images.jpg"));
		f.add(new JLabel(icon));
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new ResourceExample();
		Class clz = ResourceExample.class;
		System.out.println(clz.getResource("images.jpg"));
	}
}
