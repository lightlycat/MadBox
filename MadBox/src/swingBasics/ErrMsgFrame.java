package swingBasics;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrMsgFrame extends JFrame{
	
	public ErrMsgFrame(String title)
	{
		super(title);
		JLabel L1;
		L1 = new JLabel("Forget your username? Input again.",JLabel.CENTER );
		JFrame.setDefaultLookAndFeelDecorated(true);
		Container cp = getContentPane();
		cp.add(L1, BorderLayout.CENTER);
		
		
	}
}
