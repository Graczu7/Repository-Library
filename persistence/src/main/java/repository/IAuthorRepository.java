package repository;

import model.Author;

import java.util.List;

public interface IAuthorRepository {

    List<Author> findAllAuthors();

    Author findAuthorById(Long id);
}
