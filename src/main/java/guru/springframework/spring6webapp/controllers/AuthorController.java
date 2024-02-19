package guru.springframework.spring6webapp.controllers;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        Iterable<Author> authors = authorService.findAll();
        model.addAttribute("authors",authors);
        return "authors";
    }
}
