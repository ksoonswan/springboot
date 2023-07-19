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

    assertThat(entityManager.contains(post)).isTrue();
    assertThat(entityManager.contains(savePost)).isTrue();
    assertThat(savePost == post).isTrue();

    Post postUpdate = new Post();
    postUpdate.setId(post.getId());
    postUpdate.setTitle("hibernate");
    Post updatedPost = postRepository.save(postUpdate);// merge

    updatedPost.setTitle("whiteship");

    assertThat(entityManager.contains(updatedPost)).isTrue();
    assertThat(entityManager.contains(postUpdate)).isFalse();
    assertThat(updatedPost == postUpdate).isFalse();

    List<Post> all = postRepository.findAll();
    assertThat(all.size()).isEqualTo(1);

  }
}