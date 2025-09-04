package com.library.librarySystem.controller;


import com.library.librarySystem.model.Book;
import com.library.librarySystem.model.User;
import com.library.librarySystem.repository.BookRepository;
import com.library.librarySystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {
    @Autowired
    private  UserRepo userRepo;
    @Autowired
    private BookRepository bookRepo;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userRepo.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        User user = userRepo.findByEmail(loginRequest.getEmail());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return "Unauthorized";
        }
        return "Login successful!";
    }

    @PostMapping("/users/{userId}/read/{bookId}")
    public ResponseEntity<String> addBookToReadList(@PathVariable Long userId, @PathVariable Long bookId){
        Optional<User> userOpt = userRepo.findById(userId);
        Optional<Book> bookOpt = bookRepo.findById(bookId);

        if (userOpt.isEmpty() || bookOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOpt.get();
        Book book = bookOpt.get();

        user.getReadBooks().add(book);
        userRepo.save(user);

        return ResponseEntity.ok("Book added to your read list");
    }

    @GetMapping("/users/{userId}/read")
    public ResponseEntity<List<Book>> getUserReadBooks(@PathVariable Long userId){
        Optional<User> userOpt = userRepo.findById(userId);
        return userOpt.map(user -> ResponseEntity.ok(user.getReadBooks())).orElseGet(() -> ResponseEntity.notFound().build());
    }



    }
