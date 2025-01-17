package bj.highfiveuniversity.book.Services;

import org.springframework.stereotype.Service;

import bj.highfiveuniversity.book.Repository.BookRepository;
import bj.highfiveuniversity.book.models.Book;


import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

  

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(Long id, Book book) {
        Book bookToUpdate = bookRepository.findById(id).get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthors(book.getAuthors());
        bookToUpdate.setPublished_at(book.getPublished_at());
        bookToUpdate.setIsbn(book.getIsbn());
        bookRepository.save(bookToUpdate);

    }

    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }
    
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }
    
}
