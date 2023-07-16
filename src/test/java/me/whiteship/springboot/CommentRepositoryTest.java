package me.whiteship.springboot;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud(){
        this.createComment(99,"spring data jpa");
        this.createComment(500,"HIBERNATE SPRING");

        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC,"likeCount"));

        try (Stream<Comment> comments =  commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest)) {
            Comment firstComment = comments.findFirst().get();
            assertThat(firstComment.getLikeCount()).isEqualTo(500);
        }
    }

    private void createComment(int likeCount, String keyword){
        Comment comment = new Comment();
        comment.setLikeCount(likeCount);
        comment.setComment(keyword);
        commentRepository.save(comment);
    }
}