package repository;

import model.Borrow;

import javax.persistence.EntityManager;

public class BorrowRepository extends GenericRepository<Borrow, Long> {

    public BorrowRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
