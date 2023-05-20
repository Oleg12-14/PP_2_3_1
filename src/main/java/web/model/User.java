package web.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @Size(min = 2, message = "Имя должно содержать как минимум 2 символа.")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Имя не должно содержать цифры, пробелы, спецсимволы")
    private String name;

    @Column(name = "lastName")
    @Size(min = 2, message = "Фамилия должна содержать как минимум 2 символа.")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Фамилия не должна содержать цифры, пробелы, спецсимволы")
    private String lastName;

    @Column(name = "email")
    @Email
    private String email;

    public User(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
