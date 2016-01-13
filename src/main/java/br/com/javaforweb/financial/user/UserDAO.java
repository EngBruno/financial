package br.com.javaforweb.financial.user;

import java.util.List;

public interface UserDAO {
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public void loanding(Integer code);
	public void searchByLogin(String login);
	public List<User> list();
}
