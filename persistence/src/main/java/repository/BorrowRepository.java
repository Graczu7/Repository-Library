package repository;

import javax.persistence.EntityManager;
import java.awt.print.Book;

public class BorrowRepository extends GenericDao <Book, Long>{

    public BorrowRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
