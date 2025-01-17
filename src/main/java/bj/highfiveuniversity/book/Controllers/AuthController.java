package bj.highfiveuniversity.book.Controllers;

import bj.highfiveuniversity.book.DTO.AuthorDTO;
import bj.highfiveuniversity.book.Exceptions.ResourceNotFoundException;
import bj.highfiveuniversity.book.Services.AuthorService;
import bj.highfiveuniversity.book.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public ResponseEntity<Iterable<AuthorDTO>> getAuthors() {
        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        AuthorDTO author = authorService.getAuthorById(id);
        if (author.getId() != null) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Auteur non trouvé avec l'id " + id);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Author> searchAuthor(@RequestParam String nom) {
        Optional<Author> author = authorService.getAuthorByName(nom);
        if (author.isPresent()) {
            return new ResponseEntity<>(author.get(), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Auteur non trouvé avec le nom " + nom);
        }
    }

    @PostMapping("")
    public ResponseEntity<String> addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return new ResponseEntity<>("Auteur ajouté avec succès !", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>("Auteur avec l'id " + id + " supprimé avec succès !", HttpStatus.valueOf(204));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        authorService.updateAuthor(id, author);
        AuthorDTO updatedAuthor = authorService.getAuthorById(id);
        if (updatedAuthor.getId() != null) {
            return new ResponseEntity<>(updatedAuthor, HttpStatus.valueOf(204));
        } else {
            throw new ResourceNotFoundException("Auteur non trouvé avec l'id " + id);
        }
    }
}
