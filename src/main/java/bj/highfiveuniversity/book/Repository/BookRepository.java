package bj.highfiveuniversity.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.book.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
