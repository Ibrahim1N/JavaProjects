package com.library.librarySystem.controller;

import com.library.librarySystem.model.Book;
import com.library.librarySystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepo;

    @PostMapping("/books")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        bookRepo.save(book);
        return ResponseEntity.ok("Book Added Successfully");
    }

    @GetMapping("/books")
    public List<Book> listAllBooks(){
        return bookRepo.findAll();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Object> findBookById(@PathVariable Long id){
        Optional<Book> found = bookRepo.findById(id);
        return found.<ResponseEntity<Object>>map(book -> new ResponseEntity<>(book, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if (optionalBook.isEmpty()) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }

        Book existingBook = optionalBook.get();
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublishDate(book.getPublishDate());
        existingBook.setAvailableCopies(book.getAvailableCopies());
        // set any other fields as needed

        bookRepo.save(existingBook);
        return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isEmpty()) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
        bookRepo.deleteById(id);
        return new ResponseEntity<>("Book deleted", HttpStatus.OK);
    }

}
