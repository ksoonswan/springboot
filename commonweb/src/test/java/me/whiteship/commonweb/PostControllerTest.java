package me.whiteship.commonweb;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import me.whiteship.commonweb.post.Post;
import me.whiteship.commonweb.post.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostControllerTest {

  @Autowired
  PostRepository postRepository;

  @Autowired
//  private EntityManager entityManager;

  private Post savePost(){
    Post post = new Post();
    post.setTitle("swanJpa");
    return postRepository.save(post);
  }

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

    List<Post> all = postRepository.findByTitle("swanJpa", Sort.by("title"));
    assertThat(all.size()).isEqualTo(1);
  }

  @Test
  public void updateTitle(){
    Post spring = savePost();

    postRepository.updateTitle("updateSuccess", spring.getId());

    // DB는 업데이트가 되었지만 캐시에는 남아있으므로, "updateSuccess" 변경이 안되고, "swanJpa" 그대로이다.
    Optional<Post> byId = postRepository.findById(spring.getId());
    assertThat(byId.get().getTitle()).isEqualTo("updateSuccess");
  }

  @Test
  public void updateTitleHibernate(){
    Post spring = savePost();
    spring.setTitle("hibernate");

    List<Post> all = postRepository.findAll();
    assertThat(all.get(1).getTitle()).isEqualTo("hibernate");
  }

}