package repository;

import javax.persistence.EntityManager;

public class AuthorRepository extends GenericDao{

    public AuthorRepository(EntityManager entityManager) {
        super(entityManager);
    }

}
