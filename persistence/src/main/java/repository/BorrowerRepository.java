package repository;

import model.Borrower;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;


public class BorrowerRepository implements IBorrowerRepository {

    @Override
    public List<Borrower> findAll() {
        try (Session session = HibernateUtil.openSession()) {
            return session.createQuery("from Borrower").list();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Borrower find(Long borrowerId) {
        try (Session session = HibernateUtil.openSession()) {

            Query query = session.createQuery("from Borrower b where b.id = :id")
                    .setParameter("id", borrowerId);
            return (Borrower) query.uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
