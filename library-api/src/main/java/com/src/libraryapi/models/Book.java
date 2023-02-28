package com.src.libraryapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tb_books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "book_name", nullable = false)
    private String name;

    @Column(name = "book_year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Author author;

    public Book() {
    }
    public Book(Long id, String name, int yearOfLaunch) {
        this.id = id;
        this.name = name;
        this.year = yearOfLaunch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
