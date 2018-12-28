package by.bntu.fitr.povt.maxpeep.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user")
    private User user;
    @JoinColumn(name = "film")
    @OneToOne
    private Film film;

    public UserFilm() {
    }

    public UserFilm(User user, Film film) {
        this.user = user;
        this.film = film;
    }
}
