package repository;

import javax.persistence.EntityManager;
import java.awt.print.Book;

public class AuthorRepository extends GenericDao <Book, Long>{

    public AuthorRepository(EntityManager entityManager) {
        super(entityManager);
    }

}
