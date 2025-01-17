package bj.highfiveuniversity.book.Mapper;


import bj.highfiveuniversity.book.DTO.BookDTO;
import bj.highfiveuniversity.book.models.Book;

public class BookMapper {
    public static BookDTO toDto(Book Book){
       BookDTO bookDto = new BookDTO(Book.getId(), Book.getTitle(), Book.getIsbn(), Book.getPublished_at());
        return bookDto;
    }
}
