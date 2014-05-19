package swingBasics.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import swingBasics.entities.Coupon;


public class RetriveCoupons {
	String pid;//todo
	
	public RetriveCoupons(String pid){
		this.pid = pid;
	}
	
	public ArrayList<Coupon> getCouponsProducts(){
		ArrayList<Coupon> result = new ArrayList<Coupon>();
		
		String db_conn = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Coupon_System";
		String db_user = "sa";
		String db_pwd = "4Kids175";
		String id = "";
		
		System.out.println("id in = " + id);
		try {
	    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      Connection conn = DriverManager.getConnection(db_conn,db_user, db_pwd);
		      //System.out.println("connected");
	         Statement statement = conn.createStatement();
	         String queryString = "select pid, cid, product_name, discount_description from validate_coupon_product ";
	         System.out.println("SQL products: " + queryString);
	         ResultSet rs = statement.executeQuery(queryString);
	         
	         while (rs.next()) {
	        	 Coupon cp = new Coupon();
	        	cp.setCoupon_id(rs.getString(1));
	        	
	        	result.add(cp);
	            //System.out.println("SKU[" + i + "]::"+ rs.getString(1) + "- " + rs.getString(2)+ "- " + rs.getString(3));
	           
	         }
	         conn.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		return result;
	}
	public ArrayList<Coupon> getCoupons(){
		ArrayList<Coupon> result = new ArrayList<Coupon>();
		
		String db_conn = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Coupon_System";
		String db_user = "sa";
		String db_pwd = "4Kids175";
		
		
		System.out.println("id in = " + pid);
		try {
	    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      Connection conn = DriverManager.getConnection(db_conn,db_user, db_pwd);
		      //System.out.println("connected");
	         Statement statement = conn.createStatement(); 
	         String queryString = "select c.coupon_id,c.discount_description, cp.product_id, p.product_name "
	         		+ "from coupons as c, coupon_products as cp , Product_System.dbo.products as p "
	         		+ "where c.id = cp.coupon_id and cp.product_id = p.id"
	         		+ " and cp.product_id = " + pid ;
	         System.out.println("SQL products: " + queryString);
	         ResultSet rs = statement.executeQuery(queryString);
	         
	         while (rs.next()) {
	        	Coupon cp = new Coupon();
	        	cp.setCoupon_id(rs.getString(1));
	        	
	        	result.add(cp);
	           
	           
	         }
	         System.out.println("@coupon::" +  result.size());
	         conn.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RetriveCoupons rc = new RetriveCoupons("8");
		rc.getCoupons();

	}

}
