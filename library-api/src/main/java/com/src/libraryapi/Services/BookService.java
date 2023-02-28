package com.src.libraryapi.Services;

import com.src.libraryapi.models.Book;
import com.src.libraryapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.get();
    }


    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public void removeBook(Long id){
        bookRepository.deleteById(id);
    }

    public List<Book> findByName(String name){
        List<Book> list = bookRepository.findByNameContainingIgnoreCase(name);
        return list;
    }

    public List<Book> findBetweenYears(int date1, int date2){
        List<Book> list = bookRepository.findByYearAfterAndYearBefore(date1, date2);
        return  list;
    }

    public List<Book> findByAuthor(String name){
        List<Book> list = bookRepository.findByAuthor_NameContainsIgnoreCase(name);
        return list;
    }
}
