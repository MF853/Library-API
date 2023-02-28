package com.src.libraryapi.repositories;

import com.src.libraryapi.models.Author;
import com.src.libraryapi.models.Book;
import com.src.libraryapi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByNameContainingIgnoreCase(String name);

    List<Book> findByYearAfterAndYearBefore(int date1, int date2);

    List<Book> findByAuthor_NameContainsIgnoreCase(String name);


}
