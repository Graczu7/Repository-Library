package service;

import dto.AuthorDto;
import model.Author;

import java.util.List;

public interface IAuthorService {

    void saveAuthor(Author author);

    Long editAuthor(Author author) throws Exception;

    List<AuthorDto> findAllAuthors();
}

