package appMain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository
public class AdminMngImpl implements AdminInterface{

	public Admin returnAdmin(final String username, final String password) {
		return new HibernateTemplate()
				.returnQuery(new HibernateDatabaseReader() {

					@SuppressWarnings("unchecked")
					public Admin returnQuery(Session session) {
						Criteria cr = session.createCriteria(Admin.class);
						cr.add(Restrictions.eq("username", username));
						cr.add(Restrictions.eq("password", password));
						@SuppressWarnings("rawtypes")
						List results = cr.list();
						if (results.size() == 0) {
							return null;
						} else {
							Admin admin = (Admin) results.get(0);
							return admin;
						}

					}

				});

	}
}
