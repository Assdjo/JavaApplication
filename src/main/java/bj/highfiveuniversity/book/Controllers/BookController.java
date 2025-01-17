package bj.highfiveuniversity.book.Controllers;

import bj.highfiveuniversity.book.DTO.BookDTO;
import bj.highfiveuniversity.book.Services.BookService;
import bj.highfiveuniversity.book.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<Iterable<BookDTO>> getBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        BookDTO book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Book> getBookByTitle(@RequestParam String title) {
        Book book = bookService.getBookByTitle(title);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>("Livre ajouté avec succès !", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return new ResponseEntity<>("Livre mis à jour avec succès !", HttpStatus.valueOf(204));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Livre supprimé avec succès !", HttpStatus.valueOf(204));
    }

    @PostMapping("/{bookId}/authors/{authorId}")
    public ResponseEntity<String> linkBookToAuthor(@PathVariable Long bookId, @PathVariable Long authorId) {
        bookService.linkBookToAuthor(bookId, authorId);
        return new ResponseEntity<>("Auteur lié au livre avec succès !", HttpStatus.OK);
    }
}
