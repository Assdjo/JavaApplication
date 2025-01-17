package bj.highfiveuniversity.book.Services;

import org.springframework.stereotype.Service;

import bj.highfiveuniversity.book.DTO.BookDTO;
import bj.highfiveuniversity.book.Exceptions.ResourceNotFoundException;
import bj.highfiveuniversity.book.Mapper.BookMapper;
import bj.highfiveuniversity.book.Repository.AuthorRepository;
import bj.highfiveuniversity.book.Repository.BookRepository;
import bj.highfiveuniversity.book.models.Author;
import bj.highfiveuniversity.book.models.Book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;


    @Autowired
    private final AuthorRepository authorRepository;
    
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

  

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("livre avec l'id " + id + " n'existe pas");
        }
        bookRepository.deleteById(id);
    }

    public void updateBook(Long id, Book book) {

        Book bookToUpdate = bookRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("livre avec l'id " + id + " n'existe pas"));
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthors(book.getAuthors());
        bookToUpdate.setPublished_at(book.getPublished_at());
        bookToUpdate.setIsbn(book.getIsbn());
        bookRepository.save(bookToUpdate);

    }

    public Iterable<BookDTO> getBooks() {

       Iterable<Book>books = bookRepository.findAll();
        if (books.spliterator().getExactSizeIfKnown() == 0) {
            throw new ResourceNotFoundException("Aucun livre retrouvé");
        }
        List<BookDTO> bookList = new ArrayList<>();

        for (Book book : books) {
            bookList.add(BookMapper.toDto(book));
        }

        return bookList;
    }
    
    public BookDTO getBookById(Long id) {
       Book book = bookRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Livre non trouvé avec l'id " + id));

          return BookMapper.toDto(book);

    }

    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title)
          .orElseThrow(() -> new ResourceNotFoundException("Livre non trouvé avec le titre " + title));
    }

       public void linkBookToAuthor(Long bookId, Long authorId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Livre non trouvé avec l'id " + bookId));
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Auteur non trouvé avec l'id " + authorId));
        book.getAuthors().add(author);
        bookRepository.save(book);
    }
    
}
