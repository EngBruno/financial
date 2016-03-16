package br.com.ifce.financial.account;

import br.com.javaforweb.financial.util.DAOFactory;

public class AccountBC {
	@SuppressWarnings("unused")
	private AccountDAO accountDAO;
	public AccountBC(){
		this.accountDAO = DAOFactory.creatingAccountDAO();
	}
}
