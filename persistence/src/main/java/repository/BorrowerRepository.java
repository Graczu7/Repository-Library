package repository;

import javax.persistence.EntityManager;
import java.awt.print.Book;

public class BorrowerRepository extends GenericDao <Book, Long>{

    public BorrowerRepository(EntityManager entityManager) {
        super(entityManager);
    }

}
