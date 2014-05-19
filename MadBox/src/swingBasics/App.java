package swingBasics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
	
	
	public static void main(String[] args) {
		   
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				JFrame frame = new MainFrame("Welcome to MADBOX!!");
				frame.setLocationByPlatform(true);
				frame.setSize(500,120);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
