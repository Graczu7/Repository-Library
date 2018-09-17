import org.junit.Test;
import repository.BorrowerRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BorrowerRepositoryTest {

    @Test
    public void testInitRepository(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BorrowerRepository borrowerRepository = new BorrowerRepository(entityManager);
    }
}
