package repository;

import model.Author;

import java.util.List;

public class AuthorRepository extends GenericRepository<Author, Long> implements IAuthorRepository {

    @Override
    public List<Author> findAllAuthors() {
        return em.createQuery("select b from Author b", Author.class).getResultList();
    }

    @Override
    public Author findAuthorById(Long id) {
        return read(id);
    }
}
