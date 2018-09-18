package repository;

import model.Borrower;

import javax.persistence.EntityManager;

public class BorrowerRepository extends GenericDao <Borrower, Long>{

    public BorrowerRepository(EntityManager entityManager) {
        super(entityManager);
    }

}
