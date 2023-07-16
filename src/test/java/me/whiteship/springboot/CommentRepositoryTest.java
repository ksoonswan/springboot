package me.whiteship.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() throws ExecutionException, InterruptedException {
        this.createComment(99,"spring data jpa");
        this.createComment(500,"HIBERNATE SPRING");

        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC,"likeCount"));

        Future<List<Comment>> future = commentRepository.findByCommentContainsIgnoreCase("Spring",pageRequest);

        System.out.println("============");
        System.out.println("is done? "+future.isDone());

        List<Comment> comments = future.get();
        comments.forEach(System.out::println);

    }

    private void createComment(int likeCount, String keyword){
        Comment comment = new Comment();
        comment.setLikeCount(likeCount);
        comment.setComment(keyword);
        commentRepository.save(comment);
    }
}