package repository;

import javax.persistence.EntityManager;

public class BorrowRepository extends GenericDao {

    public BorrowRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
