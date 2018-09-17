package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    //@Column(name = "borrow", nullable = false)
    //private  borrow;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "isbn", nullable = false)
    private Date isbn;

    @Column(name = "pages", nullable = false)
    private Integer pages;

    @Column(name = "relase_date", nullable = false)
    private Date relase_date;

    @Column(name = "summary", nullable = false)
    private String summary;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


}