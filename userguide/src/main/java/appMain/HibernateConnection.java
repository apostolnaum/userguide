package appMain;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConnection {

	public static Session connection() {

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(CreditCard.class)
				.addAnnotatedClass(Admin.class)
				.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();

	}

	public static void closeSession() {
		connection().close();
	}

}
