package appMain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository
public class AccountManagementImpl implements AccountMngmInterface {

	public void createAccount(final Account account) {
		new HibernateTemplate()
				.saveOrUpdateQuery(new HibernateDatabaseWriter() {

					public Object insertQuery() {
						return account;
					}
				});

	}



	public Account returnAccount(final String email, final String password) {
		return new HibernateTemplate()
				.returnQuery(new HibernateDatabaseReader() {

					@SuppressWarnings("unchecked")
					public Account returnQuery(Session session) {
						Criteria cr = session.createCriteria(Account.class);
						cr.add(Restrictions.eq("email", email));
						cr.add(Restrictions.eq("password", password));
						@SuppressWarnings("rawtypes")
						List results = cr.list();
						if (results.size() == 0) {
							return null;
						} else {
							Account account = (Account) results.get(0);
							return account;
						}

					}

				});

	}

	public void deleteAccount(final String email) {
		new HibernateTemplate().returnQuery(new HibernateDatabaseReader() {

			public <E> E returnQuery(Session session) {
				String hql = "DELETE FROM Account WHERE email = :email_usr";
				Query query = session.createQuery(hql);
				query.setParameter("email_usr", email);
				query.executeUpdate();
				return null;
			}
		});

	}

	public void saveCreditCard(final CreditCard card) {
		new HibernateTemplate()
				.saveOrUpdateQuery(new HibernateDatabaseWriter() {

					public Object insertQuery() {

						return card;
					}
				});
	}

}
