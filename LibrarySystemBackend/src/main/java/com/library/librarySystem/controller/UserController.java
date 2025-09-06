package com.library.librarySystem.controller;


import com.library.librarySystem.model.Book;
import com.library.librarySystem.model.User;
import com.library.librarySystem.repository.BookRepository;
import com.library.librarySystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    private final UserRepo userRepo;
    private final BookRepository bookRepo;

    public UserController(UserRepo userRepo, BookRepository bookRepo) {
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        User user = userRepo.findByEmail(loginRequest.getEmail());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        return ResponseEntity.ok("Logged in successfully");
    }

    @PostMapping("/users/{userId}/read/{bookId}")
    public ResponseEntity<String> addBookToReadList(@PathVariable Long userId, @PathVariable Long bookId) {
        Optional<User> userOpt = userRepo.findById(userId);
        Optional<Book> bookOpt = bookRepo.findById(bookId);

        if (userOpt.isEmpty() || bookOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOpt.get();
        Book book = bookOpt.get();

        if (user.getReadBooks().contains(book)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Book already exists in your read list");
        }
        user.getReadBooks().add(book);
        userRepo.save(user);

        return ResponseEntity.ok("Book added to your read list");
    }

    @DeleteMapping("/users/{userId}/read/{bookId}")
    public ResponseEntity<String> deleteBookFromReadList(@PathVariable Long userId, @PathVariable Long bookId) {
        Optional<User> userOpt = userRepo.findById(userId);
        Optional<Book> bookOpt = bookRepo.findById(bookId);

        if (userOpt.isEmpty() || bookOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOpt.get();
        Book book = bookOpt.get();

        if (!user.getReadBooks().contains(book)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Book doesn't exist in your read list");
        }

        user.getReadBooks().remove(book);
        userRepo.save(user);
        return ResponseEntity.ok("Book removed successfully");

    }


    @GetMapping("/users/{userId}/read")
    public ResponseEntity<List<Book>> getUserReadBooks(@PathVariable Long userId) {
        Optional<User> userOpt = userRepo.findById(userId);
        return userOpt.map(user -> ResponseEntity.ok(user.getReadBooks())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> viewUserInfo(@PathVariable Long id) {
        Optional<User> userOpt = userRepo.findById(id);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User does not exist");
        }
        return ResponseEntity.ok(userOpt.get());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUserInfo(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> userOpt = userRepo.findById(id);

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User not found");
        }

        User user = userOpt.get();

        if (updatedUser.getEmail() != null && !updatedUser.getEmail().isBlank()) {
            User existingUser = userRepo.findByEmail(updatedUser.getEmail());
            if (existingUser != null && existingUser.getId() != id) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already in use");
            }
            user.setEmail(updatedUser.getEmail());
        }

        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isBlank()) {
            if (updatedUser.getPassword().length() < 6) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Password must be more than 6 characters");
            }
            user.setPassword(updatedUser.getPassword());
        }

        userRepo.save(user);
        return ResponseEntity.ok("User updated successfully");

    }

}
