package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.BookType;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private LocalDate release;
    private boolean borrow;
    private String isbn;
    private BookType category;
    private String description;
    private Integer pages;
    private String authorName;
    private String borrowerName;
    private Long authorId;
}
