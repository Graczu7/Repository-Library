package service;

import dto.BookDto;
import exception.AuthorNotFoundException;
import exception.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import model.*;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.IAuthorRepository;
import repository.IBookRepository;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class BookService implements IBookService {

    private final IBookRepository bookRepository;
    private final IAuthorRepository authorRepository;

    public BookService() {
        authorRepository = new AuthorRepository();
        bookRepository = new BookRepository();
    }

    @Override
    public void add(BookDto bookDto) throws AuthorNotFoundException {
        Author author = Optional.ofNullable(authorRepository.find(bookDto.getAuthorId()))
                .orElseThrow(() -> {
                    log.error("[Can not save book, the author was not found] Title: {}", bookDto.getTitle());
                    return new AuthorNotFoundException("Author was not found");
                });

        Book book = setUpBook(bookDto, new Book(), author);
        bookRepository.save(book);
        log.info("[Book has been saved] Title: {}", bookDto.getTitle());
    }

    @Override
    public void edit(BookDto bookDto) throws ItemNotFoundException {
        Book currentBook = Optional.ofNullable(bookRepository.find(bookDto.getId()))
                .orElseThrow(() -> {
                    log.error("[]Can not find book] Id: {}", bookDto.getId());
                    return new ItemNotFoundException("Can not find book");
                });

        Author author = Optional.ofNullable(authorRepository.find(bookDto.getAuthorId()))
                .orElse(currentBook.getAuthor());

        Book book = setUpBook(bookDto, currentBook, author);
        bookRepository.edit(book);
        log.info("[Book has been updated] Id: {}, Title: {}", book.getId(), book.getTitle());
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.delete(bookId);
        log.info("[Book has been deleted] Id: {}", bookId);
    }

    @Override
    public BookDto find(Long bookId) throws ItemNotFoundException {
        Book book = bookRepository.find(bookId);

        if (Objects.nonNull(book)) {
            String borrowerName = findCurrentBorrower(book);
            Long borrowId = findCurrentBorrowId(book);
            return new BookDto(book.getId(), book.getTitle(), book.getRelease(), book.getIsbn(), book.getAuthor().getDisplayName(),
                    book.getCategory(), book.getPages(), book.isBorrow(), borrowerName, book.getSummary(), book.getAuthor().getId(), borrowId);
        }
        log.error("[Can not find book] Id: {}", bookId);
        throw new ItemNotFoundException("Can not find book");
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map(b -> {
                    String borrowerName = findCurrentBorrower(b);
                    Long borrowId = findCurrentBorrowId(b);
                    return new BookDto(b.getId(), b.getTitle(), b.getRelease(), b.getIsbn(), b.getAuthor().getDisplayName(),
                            b.getCategory(), b.getPages(), b.isBorrow(), borrowerName, b.getSummary(), b.getAuthor().getId(), borrowId);
                }).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllCategories() {
        return Arrays.stream(BookType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    private Book setUpBook(BookDto bookDto, Book book, Author author) {
        book.setAuthor(author);
        book.setTitle(bookDto.getTitle());
        book.setRelease(bookDto.getRelease());
        book.setPages(bookDto.getPages());
        book.setIsbn(bookDto.getIsbn());
        book.setSummary(bookDto.getSummary());
        book.setCategory(bookDto.getCategory());
        return book;
    }

    private String findCurrentBorrower(Book book) {
        String borrowerName = null;
        if (book.isBorrow()) {
            Optional<Borrower> borrower = book.getBorrows().stream()
                    .max(Comparator.comparing(Borrow::getId))
                    .map(Borrow::getBorrower);
            if (borrower.isPresent()) {
                borrowerName = borrower.get().getDisplayName();
            }
        }
        return borrowerName;
    }

    private Long findCurrentBorrowId(Book book) {
        Long borrowId = null;
        if (book.isBorrow()) {
            Optional<Long> currentBorrowId = book.getBorrows().stream()
                    .max(Comparator.comparing(Borrow::getId))
                    .map(Borrow::getId);
            if (currentBorrowId.isPresent()) {
                borrowId = currentBorrowId.get();
            }
        }
        return borrowId;
    }
}
