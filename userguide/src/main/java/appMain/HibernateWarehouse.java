package appMain;

import java.util.ArrayList;
import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import warehouse.dao.BookWarehouse;
import warehouse.dao.Warehouse;



@Repository
public class HibernateWarehouse implements BookWarehouse, Warehouse {

	public void addBook(final Book book) {

		new HibernateTemplate().saveOrUpdateQuery(

		new HibernateDatabaseWriter() {

			public Object insertQuery() {
				return book;
			}
		});

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Book> listBooks() {

		return new HibernateTemplate()
				.returnQuery(new HibernateDatabaseReader() {

					public List<Book> returnQuery(Session session) {
						List<Book> results = session.createQuery(
								"FROM Book").list();
						return results;
					}
				});

	}

	public Book findProduct(final String title) {
		return new HibernateTemplate()
				.returnQuery(new HibernateDatabaseReader() {

					@SuppressWarnings("unchecked")
					@Override
					public Book returnQuery(Session session) {
						Criteria cr = session.createCriteria(Book.class);
						cr.add(Restrictions.eq("title", title));
						@SuppressWarnings("rawtypes")
						List results = cr.list();
						Book p = (Book) results.get(0);

						return p;
					}
				});
	}

	public Book findBookId(final Long id) {
		return new HibernateTemplate()
				.returnQuery(new HibernateDatabaseReader() {

					@SuppressWarnings("unchecked")
					@Override
					public Book returnQuery(Session session) {
						Criteria cr = session.createCriteria(Book.class);
						cr.add(Restrictions.eq("id", id));
						@SuppressWarnings("rawtypes")
						List results = cr.list();
						Book p = (Book) results.get(0);

						return p;
					}
				});
	}
	@Override
	public void addProduct(Produkt produkt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Produkt> listProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteBook(final Long id) {
		new HibernateTemplate()
		.returnQuery(new HibernateDatabaseReader() {

			@SuppressWarnings("unchecked")
			@Override
			public Book returnQuery(Session session) {
				Query q = session.createQuery("delete Book where id = :id");
				q.setParameter("id", id);
				q.executeUpdate();

				return null;
			}
		});
		
	}

}
