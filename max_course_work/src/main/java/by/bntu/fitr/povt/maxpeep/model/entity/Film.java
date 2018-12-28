package by.bntu.fitr.povt.maxpeep.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String pathToFile;
    private String genre;
    private Integer year;

    public Film() {
    }

    public Film(String title, String description, String pathToFile, String genre, Integer year) {
        this.title = title;
        this.description = description;
        this.pathToFile = pathToFile;
        this.genre = genre;
        this.year = year;
    }
}
