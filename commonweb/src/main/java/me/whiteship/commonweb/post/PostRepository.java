package me.whiteship.commonweb.post;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findByTitleStartingWith(String title);

  List<Post> findByTitle(String title);


}
