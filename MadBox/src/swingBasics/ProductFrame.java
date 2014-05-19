package swingBasics;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import swingBasics.entities.Coupon_product_view;
import swingBasics.entities.Product;
import swingBasics.model.RetriveProducts;

public class ProductFrame extends JFrame implements ActionListener{
	JFrame f;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	String bg_attribute;
	ArrayList<Coupon_product_view> products;
	
	public ProductFrame(String title, String attribute)
	{
		super(title);
		//Declare coupon variables
		String[] product_names = new String[9] ;
		String[] product_imgs = new String[9] ;
		String[] cp_amount = new String[9];
		String[] cp_des = new String[9];
		int i =0;
		
		this.bg_attribute = attribute;
		
		getProducts();
		//set default for Arrays
		Arrays.fill(product_names, "");
		Arrays.fill(product_imgs, "");
		Arrays.fill(cp_amount, "");
		Arrays.fill(cp_des, "");
		for(Coupon_product_view p: products){
			product_names[i] = p.getProduct_name();
			product_imgs[i] = p.getP_img();
			cp_amount[i]=p.getDiscount_amount();
			cp_des[i]=p.getDiscount_description();
			i++;
		}
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(3,3));
		System.out.println("img XOXO::" + products.size());
		
		
		ImageIcon icon1 = new ImageIcon(product_imgs[0]);
		ImageIcon icon2 = new ImageIcon(product_imgs[1]);
		ImageIcon icon3 = new ImageIcon(product_imgs[2]);
		ImageIcon icon4 = new ImageIcon(product_imgs[3]);
		ImageIcon icon5 = new ImageIcon(product_imgs[4]);
		ImageIcon icon6 = new ImageIcon(product_imgs[5]);
		ImageIcon icon7 = new ImageIcon(product_imgs[6]);
		ImageIcon icon8 = new ImageIcon(product_imgs[7]);
		ImageIcon icon9 = new ImageIcon(product_imgs[8]);
		
		//resize
		Image img1 = icon1.getImage();
		Image img2 = icon2.getImage();
		Image img3 = icon3.getImage();
		Image img4 = icon4.getImage();
		Image img5 = icon5.getImage();
		Image img6 = icon6.getImage();
		Image img7 = icon7.getImage();
		Image img8 = icon8.getImage();
		Image img9 = icon9.getImage();
		Image smallImg1 = img1.getScaledInstance (100,100 ,java.awt.Image.SCALE_SMOOTH);
		Image smallImg2 = img2.getScaledInstance (100,100 ,java.awt.Image.SCALE_SMOOTH);
		Image smallImg3 = img3.getScaledInstance (100,100 ,java.awt.Image.SCALE_SMOOTH);
		Image smallImg4 = img4.getScaledInstance (100,100 ,java.awt.Image.SCALE_SMOOTH);
		Image smallImg5 = img5.getScaledInstance (100,100 ,java.awt.Image.SCALE_SMOOTH);
		Image smallImg6 = img6.getScaledInstance (100,100 ,java.awt.Image.SCALE_SMOOTH);
		Image smallImg7 = img7.getScaledInstance (100,100 ,java.awt.Image.SCALE_SMOOTH);
		Image smallImg8 = img8.getScaledInstance (100,100 ,java.awt.Image.SCALE_SMOOTH);
		Image smallImg9 = img9.getScaledInstance (100,100 ,java.awt.Image.SCALE_SMOOTH);
		b1 = new JButton("<html>"+cp_amount[0]+"<br>"+cp_des[0]+"</html>", new ImageIcon(smallImg1));
		//b1.setActionCommand(products.get(0).getProduct_id());
		b2 = new JButton("<html>"+cp_amount[1]+"<br>"+cp_des[1]+"</html>", new ImageIcon(smallImg2));
		b3 = new JButton("<html>"+cp_amount[2]+"<br>"+cp_des[2]+"</html>", new ImageIcon(smallImg3));
		b4 = new JButton("<html>"+cp_amount[3]+"<br>"+cp_des[3]+"</html>", new ImageIcon(smallImg4));
		b5 = new JButton("<html>"+cp_amount[4]+"<br>"+cp_des[4]+"</html>", new ImageIcon(smallImg5));
		b6 = new JButton("<html>"+cp_amount[5]+"<br>"+cp_des[5]+"</html>", new ImageIcon(smallImg6));
		b7 = new JButton("<html>"+cp_amount[6]+"<br>"+cp_des[6]+"</html>", new ImageIcon(smallImg7));
		b8 = new JButton("<html>"+cp_amount[7]+"<br>"+cp_des[7]+"</html>", new ImageIcon(smallImg8));
		b9 = new JButton("<html>"+cp_amount[8]+"<br>"+cp_des[8]+"</html>", new ImageIcon(smallImg9));
		
		
		cp.add(b1);
		cp.add(b2);
		cp.add(b3);
		cp.add(b4);
		cp.add(b5);
		cp.add(b6);
		cp.add(b7);
		cp.add(b8);
		cp.add(b9);
		
	

		b1.addActionListener(this); 
		b2.addActionListener(this); 
		b3.addActionListener(this); 
	
		
	}
    public void getProducts(){
    	
    	System.out.println("bg_attribute::"+ bg_attribute );
    	RetriveProducts proAtts= new RetriveProducts(bg_attribute);
    	
    	//products = proAtts.getProducts();
    	products = proAtts.getCouponsProducts();
    	for(Coupon_product_view cpv : products){
    		System.out.println("coup::" +cpv.getCid()+"-" +cpv.getDiscount_amount());
    	}
    
    	
    }
	
	
	public void actionPerformed(ActionEvent e) {
		
		/*
		JFrame uf = new CouponFrame("Cupons",e.getActionCommand());
		uf.setLocationByPlatform(true);
		uf.setSize(900,500);
		//uf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //DON'T CLOSE THE PARENT WINDOW
		uf.setVisible(true);
		*/
		
}
}
