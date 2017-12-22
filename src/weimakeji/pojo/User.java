package weimakeji.pojo;

public class User {

private int userid;
private String username;
private String password;
private int status;

//修改密码表单
private  String newpass;//新密码
private String rerloginpass;//确认密码

public String getRerloginpass() {
	return rerloginpass;
}
public void setRerloginpass(String rerloginpass) {
	this.rerloginpass = rerloginpass;
}
public String getNewpass() {
	return newpass;
}
public void setNewpass(String newpass) {
	this.newpass = newpass;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

	
}
