package bj.highfiveuniversity.book.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import bj.highfiveuniversity.book.models.Book;
import bj.highfiveuniversity.book.Services.BookService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public Iterable<Book> getBooks() {
        return bookService.getBooks();
       
    }

    @PostMapping("")
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Livre ajouté avec succès !";
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/search")
    public Book searchBook(@RequestParam String title) {
        return bookService.getBookByTitle(title);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Livre avec l'id " + id + " supprimé avec succès !";
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return bookService.getBookById(id);
    }
}

   
