package appMain;


import org.hibernate.Session;

public interface HibernateDatabaseReader {
	<E> E returnQuery(Session session);
}
