package me.whiteship.springboot;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Stream;

public interface CommentRepository extends MyRepository<Comment, Long>{

    List<Comment> findByCommentContains(String keyword);

    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);

    Stream<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

}
