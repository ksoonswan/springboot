package me.whiteship.commonweb.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

  @Autowired
  CommentRepository commentRepository;

  private Comment createComment(){
    Comment comment = new Comment();
    comment.setComment("comment1");
    return commentRepository.save(comment);
  }

  @Test
  public void getComment(){
    createComment();

    commentRepository.getCommentById(1L);

    System.out.println("======================");

    commentRepository.findById(1L);

  }

}