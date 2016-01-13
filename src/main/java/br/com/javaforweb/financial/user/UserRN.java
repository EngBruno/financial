package br.com.javaforweb.financial.user;

import java.util.List;

import br.com.javaforweb.financial.util.DAOFactory;

public class UserRN {
	private UserDAO userDAO;
	public UserRN() {
		this.userDAO = DAOFactory.creatingUserDAO();
	}
	
	public User loanding(Integer code){
		return this.userDAO.loanding(code);
	}
	public User searchByLogin(String login){
		return this.userDAO.searchByLogin(login);
	}
	public void save(User user){
		Integer code = user.getCode();
		if(code==null || code==0){
			this.userDAO.save(user);
		}else{
			this.userDAO.update(user);
		}
	}
	public void delete(User user){
		this.userDAO.delete(user);
	}
	public List<User> list(){
		return this.userDAO.list();
	}
}
