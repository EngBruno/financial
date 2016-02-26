package br.com.javaforweb.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.javaforweb.financial.user.User;
import br.com.javaforweb.financial.user.UserRN;
@ManagedBean(name="userBean")
@RequestScoped
public class UserBean {
	private User user = new User();
	private String confirmPassword;
	private List<User> list;
	
	public String newUser(){
		this.user = new User();
		this.user.setActive(true);
		return "/public/user";
	}
	
	public String save(){
		FacesContext context= FacesContext.getCurrentInstance();
		
		String password = this.user.getPassword();
		if(!password.equals(this.confirmPassword)){
			FacesMessage facesMessage = new FacesMessage("A senha nao foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}
		
		UserRN userRN = new UserRN();
		userRN.save(this.user);
		return "usersuccess";
	}
	
	public void listUser(){
		UserRN userRN = new UserRN();
		this.list = userRN.list();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<User> getList() {
		UserRN userRN = new UserRN();
		if(userRN.list() == null){
			this.list = userRN.list(); 
		}
		return list;
	}
	
	
}
