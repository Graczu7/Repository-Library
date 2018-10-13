package repository;

import model.Borrow;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class BorrowRepository implements IBorrowRepository {

    @Override
    public void save(Borrow borrow) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.persist(borrow);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public Borrow find(Long borrowId) {
        try (Session session = HibernateUtil.openSession()) {
            Query query = session.createQuery("from Borrow b where b.id = :id")
                    .setParameter("id", borrowId);
            return (Borrow) query.uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(Borrow borrow) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.delete(borrow);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
