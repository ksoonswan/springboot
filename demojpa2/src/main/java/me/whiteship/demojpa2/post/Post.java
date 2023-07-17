package me.whiteship.demojpa2.post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter @Getter
public class Post {

    @Id @GeneratedValue
    private int id;

    private String title;

    @Lob
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
