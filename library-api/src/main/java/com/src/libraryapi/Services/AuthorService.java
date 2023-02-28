package com.src.libraryapi.Services;

import com.src.libraryapi.models.Author;
import com.src.libraryapi.models.Client;
import com.src.libraryapi.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    public AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthor(Long id){
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        return optionalAuthor.get();
    }

    public Author addAuthor(Author author){
        return authorRepository.save(author);
    }

    public void removeAuthor(Long id){
        authorRepository.deleteById(id);
    }

    public Author updateAuthor(Author author, Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (!optionalAuthor.isPresent()) {
            System.out.println("Author not registered.");
            return null;
        } else {
            author.setId(id);
            return authorRepository.save(author);
        }
    }
}
