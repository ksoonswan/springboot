package me.whiteship.commonweb.post;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Comment {

  @Id
  @GeneratedValue
  private Long id;

  private String comment;

  @ManyToOne()
  private Post post;

  private int up;

  private int down;

  private boolean best;

  @CreatedDate
  private Date createdAt;

  @CreatedBy
  @ManyToOne
  private Account createdBy;

  @LastModifiedDate
  private Date updatedAt;

  @LastModifiedBy
  @ManyToOne
  private Account updatedBy;

  @PrePersist
  public void prePersist() {
    System.out.println("Pre Persist is called");
    this.createdAt = new Date();
//    this.createdBy = "Swan";
  }
}
