package me.whiteship.commonweb;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class Post {

  @Id @GeneratedValue
  private Long id;

  private String title;

  private Date createdAt;
}
