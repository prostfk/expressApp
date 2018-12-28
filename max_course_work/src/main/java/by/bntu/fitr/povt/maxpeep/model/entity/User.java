package by.bntu.fitr.povt.maxpeep.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean isBlocked;

    public User() {
    }

    public User(String username, String password, boolean isBlocked) {
        this.username = username;
        this.password = password;
        this.isBlocked = isBlocked;
    }
}
