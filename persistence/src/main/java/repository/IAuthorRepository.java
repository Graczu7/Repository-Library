package repository;

import model.Author;

public interface IAuthorRepository {

    void save(Author author);

    Author find(Long authorId);
}
