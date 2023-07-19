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

  @Autowired
  PostRepository postRepository;

  @Test
  public void getComment() {
    Post post = new Post();
    post.setTitle("jps");
    Post savedPost = postRepository.save(post);

    Comment comment = new Comment();
    comment.setPost(savedPost);
    comment.setUp(10);
    comment.setDown(1);
    comment.setComment("코멘트적어!");
    commentRepository.save(comment);

    commentRepository.findByPost_Id(savedPost.getId(), CommentOnly.class).forEach(c -> {
      System.out.println("=================");
      System.out.println(c.getComment());
    });

  }

}