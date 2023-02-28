package com.src.libraryapi.Controllers;

import com.src.libraryapi.Services.BookService;
import com.src.libraryapi.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> list = bookService.getAllBooks();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Book book = bookService.getBook(id);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/consulta/find")
    public ResponseEntity<List<Book>> findBookByName(@RequestParam(name = "nome") String name){
        List<Book> list = bookService.findByName(name);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/consulta/date")
    public ResponseEntity<List<Book>> findBetweendates(@RequestParam(name = "after") int date1, @RequestParam(name = "before") int date2){
        List<Book> list = bookService.findBetweenYears(date1, date2);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/consulta/author")
    public ResponseEntity<List<Book>> findByAuthor(@RequestParam(name = "nome") String name){
        List<Book> list = bookService.findByAuthor(name);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.ok().body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeBook(@PathVariable Long id){
        bookService.removeBook(id);
        return ResponseEntity.noContent().build();
    }
}
