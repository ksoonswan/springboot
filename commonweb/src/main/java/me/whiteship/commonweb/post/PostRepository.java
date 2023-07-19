package me.whiteship.commonweb.post;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findByTitleStartingWith(String title);

  @Query("SELECT p FROM Post AS p WHERE p.title = ?1")
  List<Post> findByTitle(String title, Sort sort);


}
