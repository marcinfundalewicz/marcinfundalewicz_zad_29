package pl.javastart.jjdind84_marcinfundalewicz_zad_29.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.javastart.jjdind84_marcinfundalewicz_zad_29.role.Role;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
