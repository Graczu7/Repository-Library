package repository;

import model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class AuthorRepository implements IAuthorRepository {


    @Override
    public void save(Author author) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.persist(author);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public Author find(Long authorId) {
        try (Session session = HibernateUtil.openSession()) {
            Query query = session.createQuery("select a from Author a where a.id = :id")
                    .setParameter("id", authorId);
            return (Author) query.uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
