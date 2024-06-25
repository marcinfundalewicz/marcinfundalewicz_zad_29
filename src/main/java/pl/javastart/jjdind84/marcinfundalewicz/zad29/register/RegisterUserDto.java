package pl.javastart.jjdind84.marcinfundalewicz.zad29.register;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String role;

}
