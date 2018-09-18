package repository;

import model.Author;

import javax.persistence.EntityManager;

public class AuthorRepository extends GenericDao <Author, Long>{

    public AuthorRepository(EntityManager entityManager) {
        super(entityManager);
    }

}
