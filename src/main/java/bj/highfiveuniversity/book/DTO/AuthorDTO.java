package bj.highfiveuniversity.book.DTO;

import java.util.Set;

public class AuthorDTO {
    private Long id;
    private String prenom;
    private String nom;


    public AuthorDTO(Long id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
  
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }





    
}
