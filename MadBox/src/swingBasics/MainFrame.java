package swingBasics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import swingBasics.entities.Family;
import swingBasics.model.UserInfo;

public class MainFrame extends JFrame implements ActionListener{
	JTextField F1; 
	public MainFrame(String title)
	{
		super(title);
		//Lable 
		JLabel L1;
		
		L1 = new JLabel("Please input your PIN:",JLabel.CENTER );
		L1.setFont(new Font("Calibri",Font.PLAIN, 16));
		F1 = new JTextField("");
		Font mFont= F1.getFont().deriveFont(Font.PLAIN, 18f);
		F1.setFont(new Font("Calibri",Font.BOLD, 24));
		F1.setBounds(135, 58, 100, 40);// (x, y, width, height)
		
		//Set layout manager
		setLayout(new BorderLayout());
		
		JButton button = new JButton ("Submit");
		button.setFont(new Font("Calibri",Font.PLAIN, 16));
		
		//Add Swing components to content pane
		Container c = getContentPane();
		
		c.add(L1, BorderLayout.WEST);
		c.add(F1, BorderLayout.CENTER);
		//c.add(textArea, BorderLayout.CENTER);
		
		c.add(button, BorderLayout.SOUTH);
		
		//Add behavior
		button.addActionListener(this); 
	}	
		public void actionPerformed(ActionEvent e) {
				this.dispose();
				//textArea.append("Hello\n");
				//JOptionPane.showMessageDialog(null, "OK!");
				UserInfo uinfo = new UserInfo();
				ArrayList<Family> result  = uinfo.getMemberList(F1.getText());
				
				if(result.size()>0){
					JFrame uf = new UserFrame("Good Morning, " + F1.getText() + "!!", result);
					uf.setLocationByPlatform(true);
					uf.setSize(600,400);
					uf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					uf.setVisible(true);
				}else{
					JFrame errf = new ErrMsgFrame("Error!!");
					errf.setLocationByPlatform(true);
					errf.setSize(600,200);
					errf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					errf.setVisible(true);
				}
				
				
				
		}
		
}

