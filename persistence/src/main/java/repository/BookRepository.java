package repository;

import model.Book;

import java.util.List;

public class BookRepository extends GenericRepository<Book, Long> implements IBookRepository {

    @Override
    public List<Book> findAllBook() {
        return em.createQuery("select b from Book b", Book.class).getResultList();
    }

    @Override
    public void addBook(Book book) {
        create(book);
    }

    @Override
    public Book findBookById(Long id) {
        return read(id);
    }

    @Override
    public void editBook(Book book) {
        update(book);
    }
}
