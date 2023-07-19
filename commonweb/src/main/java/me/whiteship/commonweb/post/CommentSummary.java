package me.whiteship.commonweb.post;

import lombok.Data;

@Data
public class CommentSummary {

  private String comment;

  private int up;

  private int down;

  public String getVotes() {
    return this.up + " " + this.down;
  }
}
