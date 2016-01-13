package br.com.javaforweb.financial.util;

import br.com.javaforweb.financial.user.UserDAO;
import br.com.javaforweb.financial.user.UserDAOHibernate;

public class DAOFactory {
	public static UserDAO creatingUserDAO(){
		UserDAOHibernate userDAO = new UserDAOHibernate();
		userDAO.setSessio(HibernateUtil.getSessionFactory().getCurrentSession());
		return userDAO;
	}
}
