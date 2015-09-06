package appMain;



import org.hibernate.Session;
import org.hibernate.Transaction;


public class HibernateTemplate {

	public <E> E returnQuery(HibernateDatabaseReader databaseReader) {
		Session session = HibernateConnection.connection();
		Transaction tx = null;
		E object;
		try {
			tx = session.beginTransaction();
			object = databaseReader.returnQuery(session);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			HibernateConnection.closeSession();
		}

		return object;
	}

	public void saveOrUpdateQuery(HibernateDatabaseWriter databaseWriter) {
		Session session = HibernateConnection.connection();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Object object = databaseWriter.insertQuery();
			session.saveOrUpdate(object);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			HibernateConnection.closeSession();
		}

	}

}
