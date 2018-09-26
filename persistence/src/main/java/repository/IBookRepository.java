package repository;

import model.Book;

import java.util.List;

public interface IBookRepository {

    List<Book> findAllBook();

    void addBook(Book book);

    Book findBookById(Long id);

    void editBook(Book book);
}
