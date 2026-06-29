package com.library;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        BookRepository bookRepository = context.getBean("bookRepository", BookRepository.class);
        System.out.println("Spring context loaded successfully.");
        bookService.displayServiceInfo();
        System.out.println("BookRepository bean created successfully.");
        System.out.println("Sample book from repository: " + bookRepository.getSampleBook());
    }
}