package me.whiteship.commonweb.post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Comment {

  @Id @GeneratedValue
  private Long id;

  private String comment;

  @ManyToOne()
  private Post post;

  private int up;

  private int down;

  private boolean best;
}
