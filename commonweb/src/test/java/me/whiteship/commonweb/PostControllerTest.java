package me.whiteship.commonweb;


import static org.assertj.core.api.Assertions.assertThat;

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

  @Test
  public void crud() throws Exception {
    Post post = new Post();
    post.setTitle("jpa");
    postRepository.save(post);

    List<Post> all = postRepository.findAll();
    assertThat(all.size()).isEqualTo(1);
  }
}