package com.src.libraryapi.Controllers;

import com.src.libraryapi.Services.AuthorService;
import com.src.libraryapi.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> list = authorService.getAllAuthors();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id){
        Author author = authorService.getAuthor(id);
        return ResponseEntity.ok().body(author);
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return ResponseEntity.ok().body(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAuthor(@PathVariable Long id){
        authorService.removeAuthor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable Long id){
        author = authorService.updateAuthor(author, id);
        return ResponseEntity.ok().body(author);
    }
}