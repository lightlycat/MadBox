package swingBasics;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;




import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import swingBasics.entities.Coupon;
import swingBasics.model.RetriveCoupons;


public class CouponFrame extends JFrame implements ActionListener {
	JFrame f;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	String pid;
	public CouponFrame(String title, String pid)
	{
		super(title);
		this.pid = pid;
		JFrame.setDefaultLookAndFeelDecorated(true);
		Container cp = getContentPane();
		
		cp.setLayout(new GridLayout(2,2));
		ArrayList<Coupon> coupons = getCoupons();
		/*
		ImageIcon icon1 = new ImageIcon("src/swingBasics/images/pet-coupon-1.jpg");
		ImageIcon icon2 = new ImageIcon("src/swingBasics/images/pet-coupon-2.jpg");
		ImageIcon icon3 = new ImageIcon("src/swingBasics/images/pet-coupon-3.jpg");
		//resize
		Image img1 = icon1.getImage();
		Image img2 = icon2.getImage();
		Image img3 = icon3.getImage();
		Image smallImg1 = img1.getScaledInstance (200,140 ,java.awt.Image.SCALE_SMOOTH);
		Image smallImg2 = img2.getScaledInstance (200,140 ,java.awt.Image.SCALE_SMOOTH);
		Image smallImg3 = img3.getScaledInstance (200,140 ,java.awt.Image.SCALE_SMOOTH);
		*/
		b1 = new JButton(coupons.get(0).getCoupon_id() );
		b2 = new JButton(" " );
		b3 = new JButton(" " );
		b4 = new JButton(" " );

		
		cp.add(b1);
		cp.add(b2);
		cp.add(b3);
		cp.add(b4);
	
	
		
		//Add behavior
		b1.addActionListener(this); 
		b2.addActionListener(this); 
		b3.addActionListener(this); 
	
		
	}
	public void actionPerformed(ActionEvent e) {
		
		
		
}
	 public ArrayList<Coupon> getCoupons(){
	    	
		
	    	RetriveCoupons coupon_info= new RetriveCoupons(pid);
	    	
	    	 ArrayList<Coupon> coupons = coupon_info.getCoupons();
	    	 
	    	 for(Coupon cp : coupons){
	     		System.out.println("coupons::" + cp.getCoupon_id());
	     	}
	    	return coupons;
	    
	    	
	    }
}
