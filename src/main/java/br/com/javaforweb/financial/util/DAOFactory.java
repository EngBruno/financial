package br.com.javaforweb.financial.util;

import br.com.ifce.financial.account.Account;
import br.com.ifce.financial.account.AccountDAO;
import br.com.ifce.financial.account.AccountDAOHibernate;
import br.com.javaforweb.financial.user.UserDAO;
import br.com.javaforweb.financial.user.UserDAOHibernate;

public class DAOFactory {
	public static UserDAO creatingUserDAO(){
		UserDAOHibernate userDAO = new UserDAOHibernate();
		userDAO.setSessio(HibernateUtil.getSessionFactory().getCurrentSession());
		return userDAO;
	}
	
	public static AccountDAO creatingAccountDAO(){
		AccountDAOHibernate accountDAO = new AccountDAOHibernate();
		accountDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return accountDAO;
	}
}
