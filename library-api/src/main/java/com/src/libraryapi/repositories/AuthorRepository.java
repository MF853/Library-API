package com.src.libraryapi.repositories;

import com.src.libraryapi.models.Author;
import com.src.libraryapi.models.Book;
import com.sun.istack.internal.Interned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


}
