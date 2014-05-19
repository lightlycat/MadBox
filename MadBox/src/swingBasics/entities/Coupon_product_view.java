package swingBasics.entities;

public class Coupon_product_view {
 String pid;
 String cid;
 String product_name;
 String discount_description;
 String discount_amount;
 String end_date;
 String p_img;
 public String getP_img() {
	return p_img;
}
public void setP_img(String p_img) {
	this.p_img = p_img;
}
public String getC_img() {
	return c_img;
}
public void setC_img(String c_img) {
	this.c_img = c_img;
}
String c_img;
 public String getCoupon_id() {
	return coupon_id;
}
public void setCoupon_id(String coupon_id) {
	this.coupon_id = coupon_id;
}
String coupon_id;
public String getPid() {
	return pid;
}
public String getDiscount_amount() {
	return discount_amount;
}
public void setDiscount_amount(String discount_amount) {
	this.discount_amount = discount_amount;
}
public String getEnd_date() {
	return end_date;
}
public void setEnd_date(String end_date) {
	this.end_date = end_date;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getDiscount_description() {
	return discount_description;
}
public void setDiscount_description(String discount_description) {
	this.discount_description = discount_description;
}
 
}
