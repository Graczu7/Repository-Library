package service;

import dto.BookDto;
import model.Book;

import repository.BookRepository;
import repository.IBookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookService implements IBookService {

    private final IBookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    @Override
    public List<BookDto> findAllBook() {
        List<Book> books = bookRepository.findAllBook();

        return books.stream()
                .map(b -> new BookDto(b.getId(), b.getTitle(), b.getRelease(),
                        b.isBorrow(), b.getIsbn(), b.getCategory(), b.getDescription(), b.getPages(),
                        b.getAuthor().getDisplayName(), null, null)).collect(Collectors.toList());
    }
}
