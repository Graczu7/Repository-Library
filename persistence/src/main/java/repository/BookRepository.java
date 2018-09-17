package repository;

import javax.persistence.EntityManager;
import java.awt.print.Book;

public class BookRepository extends GenericDao<Book, Long>{

    public BookRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
