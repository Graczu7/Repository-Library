package dto;

import lombok.*;
import model.BookType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;

    @NotEmpty
    @Length(min = 2, max = 255)
    private String title;

    private LocalDate release;

    @NotEmpty
    @Length(max = 13)
    private String isbn;

    private String authorName;

    private BookType category;

    private Integer pages;

    private Boolean borrow;

    private String borrowerName;

    private String summary;

    @NotNull
    private Long authorId;

    private Long borrowId;
}
