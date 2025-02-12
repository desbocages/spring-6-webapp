package guru.springframework.spring6webapp.controllers;

import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping("/books")
    public String getBooks(Model model){
        Iterable<Book> books = bookService.findAll();
        model.addAttribute("books",books);
        return "books";
    }
}
