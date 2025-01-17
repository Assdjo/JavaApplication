package bj.highfiveuniversity.book.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.book.Services.AuthorService;
import bj.highfiveuniversity.book.models.Author;

@RestController
@RequestMapping("/authors") 
public class AuthController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public Iterable<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/{id}")    
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/search")
    public Author searchAuthor(@RequestParam String nom) {
        return authorService.getAuthorByName(nom);
    }

    @PostMapping("")
    public String addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return "Auteur ajouté avec succès !";
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "Auteur avec l'id " + id + " supprimé avec succès !";
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        authorService.updateAuthor(id, author);
        return authorService.getAuthorById(id);
    }


}
