package me.whiteship.commonweb.post;

import static me.whiteship.commonweb.post.CommentSpecs.isBest;
import static me.whiteship.commonweb.post.CommentSpecs.isGood;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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


  @Test
  public void specs() {
    Comment comment = new Comment();
    comment.setUp(10);
    comment.setDown(1);
    comment.setComment("코멘트적어!");
    commentRepository.save(comment);
    Page<Comment> page = commentRepository.findAll(isBest().and(isGood()),
        PageRequest.of(0, 10));
  }

  @Test
  public void abe() {
    Comment prove = new Comment();
    prove.setBest(true);

    ExampleMatcher exampleMatcher = ExampleMatcher.matching()
        .withIncludeNullValues();

    Example<Comment> example = Example.of(prove, exampleMatcher);

    commentRepository.findAll(example);

  }

}