import org.junit.Test;
import repository.AuthorRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AuthorRepositoryTest {

    @Test
    public void testInitRepository(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AuthorRepository authorRepository = new AuthorRepository(entityManager);
    }
}
