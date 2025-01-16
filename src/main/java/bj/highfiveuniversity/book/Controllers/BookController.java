package bj.highfiveuniversity.book.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.book.models.Book;

import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping("")
    public String getBooks() {
        return "Liste de tous les livres"; 
    }

    @PostMapping("")
    public Book addBook(@RequestBody Book book) {
        return book;
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id) {
        return "Détails du livre avec l'id : " + id;
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String title, @RequestParam String author) {
        return "Résultat de la recherche : " + title + " de l'auteur " + author;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        return "Livre avec l'id " + id + " supprimé avec succès !";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id) {
        return "Livre avec l'id " + id + " modifié avec succès !";
    }
}
