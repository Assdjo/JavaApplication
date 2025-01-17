package bj.highfiveuniversity.book.Services;

import bj.highfiveuniversity.book.DTO.AuthorDTO;
import bj.highfiveuniversity.book.Exceptions.ResourceNotFoundException;
import bj.highfiveuniversity.book.Mapper.AuthorMapper;
import bj.highfiveuniversity.book.Repository.AuthorRepository;
import bj.highfiveuniversity.book.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<AuthorDTO> getAuthors() {
        Iterable<Author> authors = authorRepository.findAll();
        if (authors.spliterator().getExactSizeIfKnown() == 0) {
            throw new ResourceNotFoundException("Aucun Auteur retrouvé");
        }
        List<AuthorDTO> authorDTO =new ArrayList<>();
        for (Author author : authors) {
            authorDTO.add(AuthorMapper.toDto(author));
        }
        return authorDTO;
    }

    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Auteur non trouvé avec l'id " + id));
        return AuthorMapper.toDto(author);
    }

    public Optional<Author> getAuthorByName(String nom) {
        return authorRepository.findByNom(nom);
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Auteur avec l'id " + id + " n'existe pas");
        }
        authorRepository.deleteById(id);
    }

    public void updateAuthor(Long id, Author author) {
        Author authorToUpdate = authorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Auteur avec l'id " + id + " n'existe pas"));
        authorToUpdate.setNom(author.getNom());
        authorToUpdate.setPrenom(author.getPrenom());
        authorToUpdate.setBooks(author.getBooks());
        authorRepository.save(authorToUpdate);
    }
}
