package bj.highfiveuniversity.book.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.book.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book>findByTitle(String title);
}
