package action;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

import org.apache.catalina.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DBUtil.DBUtil;
import DBUtil.UserBean;

public class UserAction extends ActionSupport{
	
	/**
	 * 
	 */
	//<constant name="struts.enable.DynamicMethodInvocation" value="true"/>
	private String name;
	private String password;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String register() throws Exception{
	//对用户次信息进行保存
		System.out.println("register");
		//用户名为以检验
//		Set<String> keys = DBUtil.getInstance().getUserTable().keySet();
//		for(String key: keys){  
//            if(key.equals(name)){
//            	try {
//					throw new Exception("用户名已存在");
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//            	return "error";
//            }
//        }  
		
		
		UserBean user = new UserBean(name, password, email);
		DBUtil.getInstance().insert(user);
		return "login";
	}
	public String login(){
		//对用户次信息进行保存
			System.out.println("login");
			if(password.equals(DBUtil.getInstance().getUser(name).getPassword())){
				System.out.println("登陆成功");
				//将信息存到session中
				ActionContext ac = ActionContext.getContext();
				ac.getSession().put("name", name);
				ac.getSession().put("password", password);
				ac.getSession().put("email", email);
				return "main";
			}
			System.out.println("登陆失败");
			return "login";
		}
	
	public void validate(){
		//注册信息的检验
		System.out.println("信息校验");
		if(name.equals("")||password.length()<6||email.equals("")){
			this.addFieldError(name, "用户名不能为空");
		}
		
	}
}
