package br.com.javaforweb.financial.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAOHibernate implements UserDAO {
	private Session session;
	public void setSessio(Session session){
		this.session = session;
	}

	@Override
	public void save(User user) {
		this.session.save(user);
	}

	@Override
	public void update(User user) {
		this.session.update(user);
	}

	@Override
	public void delete(User user) {
		this.delete(user);
	}

	@Override
	public User loanding(Integer code) {
		return (User)this.session.get(User.class, code);
	}

	@Override
	public User searchByLogin(String login) {
		String url= "select u from User u where u.login=:login";
		Query queryOfLogin = this.session.createQuery(url);
		queryOfLogin.setString("login", login);
		return (User) queryOfLogin.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser() {
//		System.out.println(this.session.createCriteria(User.class).list().toString());
		return this.session.createCriteria(User.class).list();
	}

}
