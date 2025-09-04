package src.main.java.com.library.librarySystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrarySystemApplication {

	public static void main(String[] args) {
		org.springframework.context.ConfigurableApplicationContext run = SpringApplication.run(LibrarySystemApplication.class, args);
	}

}
