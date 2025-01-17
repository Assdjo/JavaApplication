package bj.highfiveuniversity.book.Mapper;

import bj.highfiveuniversity.book.DTO.AuthorDTO;
import bj.highfiveuniversity.book.models.Author;

public class AuthorMapper {

    public static AuthorDTO toDto(Author author){
        AuthorDTO authorDto = new AuthorDTO(author.getId(), author.getPrenom(), author.getNom());
        return authorDto;
    }
}
