package br.com.javaforweb.financial.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.javaforweb.financial.util.HibernateUtil;

public class ConnectionHibernateFilter implements Filter {

	private SessionFactory sessionFactory;
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		Session currentSession = this.sessionFactory.getCurrentSession();
		
		Transaction transaction = null;
		try{
			transaction = currentSession.beginTransaction();
			chain.doFilter(servletRequest, servletResponse);
			transaction.commit();
			if(currentSession.isOpen()){
				currentSession.close();
			}
		}catch(Throwable ex){
			try{
				if(transaction.isActive()){
					transaction.rollback();
				}
			}catch(Throwable t){
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}
	}
	@Override
	public void destroy() {}
}
