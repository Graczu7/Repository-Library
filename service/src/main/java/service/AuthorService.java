package service;

import dto.AuthorDto;
import model.Author;
import repository.AuthorRepository;
import repository.IAuthorRepository;

import java.util.List;


public class AuthorService implements IAuthorService {

    private final IAuthorRepository authorRepository;

    public AuthorService() {
        authorRepository = new AuthorRepository();
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Long editAuthor(Author author) throws Exception {
        return null;
    }

    @Override
    public List<AuthorDto> findAllAuthors() {
        return null;
    }

}
