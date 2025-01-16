package bj.highfiveuniversity.book.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

import jakarta.persistence.Column;

@Entity
@Table(name = "editors")
public class Editor {
    @Id
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String adresse;

@OneToMany(mappedBy = "editor")
private Set<Book> books;

}
