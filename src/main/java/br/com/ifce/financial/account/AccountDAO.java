package br.com.ifce.financial.account;

import java.util.List;

import br.com.javaforweb.financial.user.User;

public interface AccountDAO {
	public void save(Account account);
	public void delete(Account account);
	public Account loanding(Account account);
	public List<Account> listAccount(User user);
	public Account searchForFavorite(User user);
}
