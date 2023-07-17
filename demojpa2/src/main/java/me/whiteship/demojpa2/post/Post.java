package me.whiteship.demojpa2.post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Date;

@Entity
@Setter @Getter
public class Post extends AbstractAggregateRoot {

    @Id @GeneratedValue
    private int id;

    private String title;

    @Lob
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Post publish() {
        this.registerEvent(new PostPublishedEvent(this));
        return this;
    }
}
