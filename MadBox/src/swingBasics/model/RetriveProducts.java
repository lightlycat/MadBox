package swingBasics.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import swingBasics.entities.*;

public class RetriveProducts {
	public String attribute;
	public ArrayList<String> pids;

	public RetriveProducts(String attribute) {

		String[] tys = attribute.split(",");
		if (tys.length > 1) {

			System.out.println("RetriveProducts:gender-age: " + tys[0] + "-"
					+ tys[1]);
			getAttributeByFamilyInfo(tys[0], tys[1]);

		} else {
			System.out.println("RetriveProducts:gender: " + tys[0]);
			getAttributeByFamilyInfo(tys[0], null);
		}

		// set up an attribute

		pids = getProductAttributeList();

	}

	public ArrayList<Product> getProducts() {
		ArrayList<Product> result = new ArrayList<Product>();

		String db_conn = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Product_System";
		String db_user = "sa";
		String db_pwd = "4Kids175";
		String id = "";
		for (String pid : pids) {
			id += "," + pid;
		}
		System.out.println("id in = " + id);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(db_conn, db_user,
					db_pwd);
			// System.out.println("connected");
			Statement statement = conn.createStatement();
			String queryString = "select id, product_name,img, brand,manufacturer  from products "
					+ "where id in (" + id.substring(1) + ")";
			System.out.println("SQL products: " + queryString);
			ResultSet rs = statement.executeQuery(queryString);

			while (rs.next()) {
				Product pd = new Product();
				pd.setProduct_id(rs.getString(1));
				pd.setProduct_name(rs.getString(2));
				pd.setImg(rs.getString(3));
				pd.setBrand(rs.getString(4));
				pd.setManufacturer(rs.getString(5));
				result.add(pd);
				// System.out.println("SKU[" + i + "]::"+ rs.getString(1) + "- "
				// + rs.getString(2)+ "- " + rs.getString(3));

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Coupon_product_view> getCouponsProducts() {
		ArrayList<Coupon_product_view> result = new ArrayList<Coupon_product_view>();

		String db_conn = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Coupon_System";
		String db_user = "sa";
		String db_pwd = "4Kids175";
		String id = "";
		for (String pid : pids) {
			id += "," + pid;
		}
		System.out.println("id in = " + id);
		if(id.length()>0){
			
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(db_conn, db_user,
					db_pwd);
			// System.out.println("connected");
			Statement statement = conn.createStatement();
			String queryString = "select pid,cid,product_name"
					+ ",discount_amount, discount_description,end_date"
					+ ",coupon_id,p_img,c_img"
					+ " from validate_coupon_product  " + "where pid in ("
					+ id.substring(1) + ")";
			System.out.println("SQL products: " + queryString);
			ResultSet rs = statement.executeQuery(queryString);

			while (rs.next()) {
				Coupon_product_view pd = new Coupon_product_view();
				pd.setPid(rs.getString(1));
				pd.setCid(rs.getString(2));
				pd.setProduct_name(rs.getString(3));
				pd.setDiscount_amount(rs.getString(4));
				pd.setDiscount_description(rs.getString(5));
				pd.setEnd_date(rs.getString(6));
				pd.setCoupon_id(rs.getString(7));
				pd.setP_img(rs.getString(8));
				pd.setC_img(rs.getString(9));

				result.add(pd);
				// System.out.println("SKU[" + i + "]::"+ rs.getString(1) + "- "
				// + rs.getString(2)+ "- " + rs.getString(3));

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return result;
	}

	public ArrayList<String> getProductAttributeList() {
		ArrayList<String> result = new ArrayList<String>();
		String db_conn = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Product_System";
		String db_user = "sa";
		String db_pwd = "4Kids175";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(db_conn, db_user,
					db_pwd);
			// System.out.println("connected");
			Statement statement = conn.createStatement();
			String queryString = "select product_id, attribute_id from product_attributes where "
					+ "attribute_id = '" + attribute + "'";
			ResultSet rs = statement.executeQuery(queryString);
			System.out.println("SQL :" + queryString);
			while (rs.next()) {

				result.add(rs.getString(1));
			}
			System.out.println("product numbers:: " + result.size());
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void getAttributeByFamilyInfo(String att, String sub_att) {

		// System.out.println("getAttributeByFamilyInfo :" + att + "-" + sub_att
		// );
		String db_conn = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Product_System";
		String db_user = "sa";
		String db_pwd = "4Kids175";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(db_conn, db_user,
					db_pwd);
			// System.out.println("connected@getAttributeByFamilyInfo ");
			Statement statement = conn.createStatement();
			String queryString = "";

			/*
			 * if(att.equals("1")){ att = "female"; }else{ att = "male"; }
			 */
			if (sub_att != null && att != null) {
				queryString = "select top 1 id, category, lower_age,upper_age "
						+ "from attributes where category = '" + att + "' "
						+ "and lower_age < " + Integer.valueOf(sub_att)
						+ " order by upper_age desc";
			} else {
				queryString = "select id, category "
						+ "from attributes where category = '" + att + "' ";
			}
			// System.out.println("sql:: " + queryString );
			ResultSet rs = statement.executeQuery(queryString);
			while (rs.next()) {
				this.attribute = rs.getString(1);
				System.out.println("getAttributeByFamilyInfo:: " + attribute);

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
