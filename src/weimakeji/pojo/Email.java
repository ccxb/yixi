package weimakeji.pojo;

public class Email {
   private String custEmail;//收件人
   private String text;//邮件内容
   private String top;//主题
   
public String getTop() {
	return top;
}
public void setTop(String top) {
	this.top = top;
}
public String getCustEmail() {
	return custEmail;
}
public void setCustEmail(String custEmail) {
	this.custEmail = custEmail;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
   
}
