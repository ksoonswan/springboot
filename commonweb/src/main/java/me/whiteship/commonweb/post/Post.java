package me.whiteship.commonweb.post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class Post {

  @Id @GeneratedValue
  private Long id;

  private String title;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
}
