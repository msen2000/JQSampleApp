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
	private String loginname;
    private String name;
	private String password;
    private String errorMessage;
    

    public LoginBean() {
        super();
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
        if(loginname.equals("admin") &&  password.equals("admin")){
//            return "adminHome";
        	System.out.println("CheckValidUser : valid user !");
        	
            return "adminLanding";
        }
        else{
            //return "fail";
        	System.out.println("CheckValidUser : NOT valid user !");
            errorMessage = "Login Failed. Plesase try again with adim/admin !!!";
            return "login";
        }
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
