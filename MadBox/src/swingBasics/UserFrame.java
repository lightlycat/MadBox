package swingBasics;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import swingBasics.entities.Family;

public class UserFrame extends JFrame implements ActionListener{
	JFrame f;
	JButton b1,b2,b3,b4,b5,b6;
	String[] names = new String[6];
	String[] types = new String[6];
	String[] relationsips = new String[6];
	ArrayList<String> pets = new ArrayList<String>();
	
	public UserFrame(String title, ArrayList<Family> uf)
	{
		super(title);
		JFrame.setDefaultLookAndFeelDecorated(true);
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2,3));
		int i=0;
		Arrays.fill(names, "");
		Arrays.fill(types, "");
		Arrays.fill(relationsips, "");
		for(Family fam: uf){
			System.out.println(" breed: " + fam.getPet_breed());
			names[i] = fam.getName().toString();
			if(fam.getPet_breed() == null){
				
					
					//pass attribution to product frame
					
						types[i] = fam.getGender().toString()+ "," + fam.getAge().toString()+"," + fam.getRelationship().toString();
						System.out.println(" family info: " + types[i]);
					}else{
						types[i] = fam.getPet_breed().toString()+ "," + fam.getAge().toString()+"," + fam.getRelationship().toString();
						System.out.println(" pet info: " + types[i]);
					}
					
					//relationsips[i] = fam.getRelationship().toString();
				
			//}
			
			//if(fam.getPet_breed()!= null){
			  //pets.add(fam.getPet_breed());
			//}
			i++;
		}
	
		
		
		if( !names[0].equals("")){
			b1 = new JButton(names[0]+" ( "+types[0]+" )");
		}else{
			b1 = new JButton("");
		}
		if( !names[1].equals("")){
			b2 = new JButton(names[1]+" ( "+types[1]+" )");
		}else{
			b2 = new JButton("");
		}
		if( !names[2].equals("")){
			b3 = new JButton(names[2]+" ( "+types[2]+" )");
		}else{
			b3 = new JButton("");
		}
		if( !names[3].equals("")){
			b4 = new JButton(names[3]+" ( "+types[3]+" )");
		}else{
			b4 = new JButton("");
		}
		if( !names[4].equals("")){
			b5 = new JButton(names[4]+" ( "+ types[4]+" )");
		}else{
			b5 = new JButton("");
		}
		
		if( !names[5].equals("")){
			b6 = new JButton(names[5]+" ( "+types[5]+" )");
		}else{
			b6 = new JButton("");
		}
		b1.setActionCommand(types[0]);
		b2.setActionCommand(types[1]);
		b3.setActionCommand(types[2]);
		b4.setActionCommand(types[3]);
		b5.setActionCommand(types[4]);
		b6.setActionCommand(types[5]);
		//b6 = new JButton(uf.getFamilies().get("pet"),icon);
		/*
		if(pets.size()>0){
			ImageIcon icon = new ImageIcon("src/swingBasics/images/catsdogs.jpg");
			b6 = new JButton(icon);
			b6.setActionCommand(pets.get(0));
			
			
		}else{
			b6 = new JButton();
		}*/
		cp.add(b1);
		cp.add(b2);
		cp.add(b3);
		cp.add(b4);
		cp.add(b5);
		cp.add(b6);
		
		
		//Add behavior
		b1.addActionListener(this); 
		b2.addActionListener(this); 
		b3.addActionListener(this); 
		b4.addActionListener(this); 
		b5.addActionListener(this);
		b6.addActionListener(this); 
		
		
	}
	public void actionPerformed(ActionEvent e) {
		//this.dispose();
		//textArea.append("Hello\n");
		//JOptionPane.showMessageDialog(null, "OK!");
		
		JFrame uf = new ProductFrame("Products",e.getActionCommand());
		//System.out.println("we are going to open product frame ::" + e.getActionCommand());
		uf.setLocationByPlatform(true);
		uf.setSize(800,600);
		//uf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //DON'T CLOSE THE PARENT WINDOW
		uf.setVisible(true);
		
}
}
