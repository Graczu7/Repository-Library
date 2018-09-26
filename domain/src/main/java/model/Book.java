package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "release_date")
    private LocalDate release;

    private boolean borrow;

    @Column(nullable = false, unique = true, length = 13)
    private String isbn;

    @Enumerated(EnumType.STRING)
    private BookType category;

    private String description;

    private Integer pages;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}