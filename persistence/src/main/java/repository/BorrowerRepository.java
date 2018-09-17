package repository;

import javax.persistence.EntityManager;

public class BorrowerRepository extends GenericDao{

    public BorrowerRepository(EntityManager entityManager) {
        super(entityManager);
    }

}
