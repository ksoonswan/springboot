package me.whiteship.commonweb.post;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findByTitleStartingWith(String title);

  @Query("SELECT p FROM #{#entityName} AS p WHERE p.title = :title")
  List<Post> findByTitle(@Param("title") String keyword, Sort sort);


}
