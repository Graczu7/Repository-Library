import org.junit.Test;
import repository.BorrowRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BorrowRepositoryTest {

    @Test
    public void testInitRepository(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BorrowRepository borrowRepository = new BorrowRepository(entityManager);
    }
}
