package service;

import dto.BookDto;
import exception.AuthorNotFoundException;
import exception.ItemNotFoundException;

import java.util.List;

public interface IBookService {

    void add(BookDto bookDto) throws AuthorNotFoundException;

    void edit(BookDto bookDto) throws ItemNotFoundException;

    void delete(Long bookId);

    BookDto find(Long bookId) throws ItemNotFoundException;

    List<BookDto> findAll();

    List<String> findAllCategories();
}
