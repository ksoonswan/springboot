package me.whiteship.commonweb.post;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {

  @EntityGraph(attributePaths = "post")
  Optional<Comment> getCommentById(Long id);

  @Transactional(readOnly = true)
  <T> List<T> findByPost_Id(Long id, Class<T> type);


}
