package swingBasics.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import swingBasics.entities.*;

public class UserInfo {
	String db_conn = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Loyalty_System";
	String db_user = "sa";
	String db_pwd = "4Kids175";
	
	@SuppressWarnings("finally")
	public ArrayList<Family> getMemberList(String input_name){
		ArrayList<Family> result = new ArrayList<Family>();
		try {
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         Connection conn = DriverManager.getConnection(db_conn,db_user, db_pwd);
	         System.out.println("connected");
	         Statement statement = conn.createStatement();
	         String queryString = "select "
	         		+ "b.name, b.relationship, DATEDIFF(year,b.birthday,getdate()) as age"
	         		+ ", b.gender,b.pet_breed "
	         		+ "from customer_info as a, customer_family as b "
	         		+ " where a.id = b. root_customerid "
	         		+ " and customer_id = '" + input_name + "'  order by age desc";
	         ResultSet rs = statement.executeQuery(queryString);
	         System.out.println("query families SQL: "  + queryString);
	         while (rs.next()) {
	        	 Family family = new Family();
	        	 family.setName(rs.getString(1));
	        	 family.setRelationship(rs.getString(2));
	        	 family.setAge(rs.getString(3));
	        	 family.setGender(rs.getString(4));
	        	 family.setPet_breed(rs.getString(5));
	        	 result.add(family);
	            
	         }
	         System.out.println("result families: "  + result.get(5).getPet_breed());
	         conn.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	    return result;
	      
	   }

	
	 public Boolean isMember(String input_name){
		 Boolean result = false;
	      try {
	    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      Connection conn = DriverManager.getConnection(db_conn,db_user, db_pwd);
		      System.out.println("connected");
	         Statement statement = conn.createStatement();
	         String queryString = "select * from customer_info where customer_id = '" + input_name + "'" ;
	         ResultSet rs = statement.executeQuery(queryString);
	         while (rs.next()) {
	            System.out.println(rs.getString(1));
	            result = true;
	         }
	         conn.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return result;
	   }

	   public static void main(String[] args)
	   {
		  UserInfo connServer = new UserInfo();
		  Boolean result = connServer.isMember("olivia");
		  System.out.println("result = " + result);
	      
	   }
	}