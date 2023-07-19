package me.whiteship.commonweb.post;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

  @EntityGraph(attributePaths = "post")
  Optional<Comment> getCommentById(Long id);

//  List<CommentSummary> findByPost_Id(Long id);

  <T> List<T> findByPost_Id(Long id, Class<T> type);


}
