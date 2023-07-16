package me.whiteship.springboot;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    private Post post;

    private Date created;

    private Integer likeCount;

}
