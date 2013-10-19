package org.sen.view.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loginname;  // username
	private String password;   // password
	private String errorMessage; //login failure error message

    public LoginBean() {    	
        super();
        errorMessage="";
    }
    
    public String getLoginname(){
        return loginname;
    }
    
    public void setLoginname(String loginname){
        this.loginname = loginname;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String CheckValidUser() {
    	errorMessage = "";
        if(loginname.equals("admin") &&  password.equals("admin")){
        	System.out.println("CheckValidUser : valid user !");
            return "adminhome";
        } else {           
        	System.out.println("CheckValidUser : NOT valid user !");
            errorMessage = "Login Failed. Plesase try again with valid user and password!!!";
            return "adminlogin";
        }
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
