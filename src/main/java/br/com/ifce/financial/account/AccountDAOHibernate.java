package br.com.ifce.financial.account;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.javaforweb.financial.user.User;

public class AccountDAOHibernate implements AccountDAO{

	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}

	public void save(Account account) {
		this.session.saveOrUpdate(account);
	}

	public void delete(Account account) {
		this.session.delete(session);
	}

	public Account loanding(Account account) {
		return (Account)this.session.get(Account.class, account);
	}

	@SuppressWarnings("unchecked")
	public List<Account> listAccount(User user) {
		Criteria criteria = this.session.createCriteria(Account.class);
		criteria.add(Restrictions.eq("user",user));
		return criteria.list();
	}

	public Account searchForFavorite(User user) {
		Criteria criteria = this.session.createCriteria(Account.class);
		criteria.add(Restrictions.eq("user",user));
		criteria.add(Restrictions.eq("favorite",true));
		return (Account)criteria.uniqueResult();
	}
	
}
