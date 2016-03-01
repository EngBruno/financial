package br.com.javaforweb.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.javaforweb.financial.user.User;
import br.com.javaforweb.financial.user.UserBC;
@ManagedBean(name="userBean")
@RequestScoped
public class UserBean {
	private User user = new User();
	private String confirmPassword;
	private List<User> listUser;
	private String destinySave;
	
	public String newUser(){
		this.destinySave = "usersuccess";
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
		
		UserBC userRN = new UserBC();
		userRN.save(this.user);
		return this.destinySave;
	}
	
	public String edit(){
		this.confirmPassword = this.user.getPassword();
		return "/public/user";
	}
	
	public String delete(){
		UserBC userBC= new UserBC();
		userBC.delete(this.user);
//		this.listUser = null;
		return null;
	}
	
	public String activate(){
		if(this.user.isActive()){
			this.user.setActive(false);
		}else{
			this.user.setActive(true);
		}
		
		UserBC userBC = new UserBC();
		userBC.save(this.user);
		return null;
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

	public void setListUser(List<User> list) {
		this.listUser = list;
	}
	
	public String getDestinySave() {
		return destinySave;
	}

	public void setDestinySave(String destinySave) {
		this.destinySave = destinySave;
	}
	
	public List<User> getListUser() {
		UserBC userBC = new UserBC();
		if(userBC.list() != null){
			this.listUser = userBC.list();
		}
		return this.listUser;
	}
	
	
	
}
