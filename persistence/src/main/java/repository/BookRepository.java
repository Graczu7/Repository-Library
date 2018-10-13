package repository;

import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {


    @Override
    public void save(Book book) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.persist(book);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public List<Book> findAll() {

        try (Session session = HibernateUtil.openSession()) {
            return session.createQuery("from Book").list();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Book find(Long bookId) {
        try (Session session = HibernateUtil.openSession()) {

            Query query = session.createQuery("from Book b where b.id = :id")
                    .setParameter("id", bookId);
            return (Book) query.uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public void edit(Book book) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.update(book);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public void delete(Serializable bookId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            Book book = session.load(Book.class, bookId);
            session.delete(book);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
