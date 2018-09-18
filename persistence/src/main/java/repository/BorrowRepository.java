package repository;

import model.Borrow;

import javax.persistence.EntityManager;

public class BorrowRepository extends GenericDao <Borrow, Long>{

    public BorrowRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
