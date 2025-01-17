package bj.highfiveuniversity.book.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniversity.book.Repository.AuthorRepository;
import bj.highfiveuniversity.book.models.Author;


@Service
public class AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthor(Long id, Author author) {
        Author authorToUpdate = authorRepository.findById(id).get();
        authorToUpdate.setNom(author.getNom());
        authorToUpdate.setPrenom(author.getPrenom());
        authorToUpdate.setNationalite(author.getNationalite());

        authorRepository.save(authorToUpdate);

    }

    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }
    
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }
    
    public Author getAuthorByName(String nom) {
        return authorRepository.findByNom(nom).get();
    }


}
