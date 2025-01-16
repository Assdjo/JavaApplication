package bj.highfiveuniversity.book.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    private Long id;

    @Column(nullable = false)
    private String nom;

    @OneToMany(mappedBy = "category")
    private Set<Book> books;
}
