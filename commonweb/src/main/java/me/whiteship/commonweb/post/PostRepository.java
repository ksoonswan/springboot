package me.whiteship.commonweb.post;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findByTitleStartingWith(String title);

  @Query("SELECT p FROM #{#entityName} AS p WHERE p.title = :title")
  List<Post> findByTitle(@Param("title") String keyword, Sort sort);

  @Modifying(clearAutomatically = true)
  @Query("UPDATE Post p SET p.title =?1 WHERE p.id = ?2")
  int updateTitle(String updateSuccess, Long id);

  Optional<Post> findById(Long id);
}
