package me.whiteship.querydsldemo.account;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String firstName;

    private String lastName;
}
