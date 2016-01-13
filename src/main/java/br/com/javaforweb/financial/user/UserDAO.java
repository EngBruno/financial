package br.com.javaforweb.financial.user;

import java.util.List;

public interface UserDAO {
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User loanding(Integer code);
	public User searchByLogin(String login);
	public List<User> list();
}
