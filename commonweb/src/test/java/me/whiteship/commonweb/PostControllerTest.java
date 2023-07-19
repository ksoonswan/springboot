package me.whiteship.commonweb;


import static org.assertj.core.api.Assertions.assertThat;

import jakarta.persistence.EntityManager;
import java.util.List;
import me.whiteship.commonweb.post.Post;
import me.whiteship.commonweb.post.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostControllerTest {

  @Autowired
  PostRepository postRepository;

  @Autowired
  private EntityManager entityManager;

  @Test
  public void save(){
    Post post = new Post();
    post.setTitle("swanJpa");
    Post savePost = postRepository.save(post);// persist

    List<Post> all = postRepository.findAll();
    assertThat(all.size()).isEqualTo(1);
  }

  @Test
  public void findByTitleStartingWith(){
    savePost();

    List<Post> all = postRepository.findByTitleStartingWith("swan");
    assertThat(all.size()).isEqualTo(1);
  }

  @Test
  public void findByTitle(){
    savePost();

    List<Post> all = postRepository.findByTitle("swanJpa");
    assertThat(all.size()).isEqualTo(1);
  }

  private void savePost(){
    Post post = new Post();
    post.setTitle("swanJpa");
    postRepository.save(post);
  }
}