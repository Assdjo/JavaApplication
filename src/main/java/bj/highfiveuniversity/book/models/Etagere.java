package bj.highfiveuniversity.book.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "etageres")
public class Etagere {
    @Id
    private Long id;

    @Column(nullable = false)
    private Long numero;

    @Column(nullable = true)
    private String emplacement;

    @OneToMany(mappedBy = "etagere")
    private Set<Book> books;
}
