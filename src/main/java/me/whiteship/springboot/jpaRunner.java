package me.whiteship.springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class jpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
/*        Post post = new Post();
        post.setTitle("Spring Date JPA 언제보나...");

        Comment comment = new Comment();
        comment.setComment("빨리보자....");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment.setComment("바로 볼 수 있을꺼야!");
        post.addComment(comment1);*/

        Session session = entityManager.unwrap(Session.class);
//        session.save(post);

        Post post = session.get(Post.class,1);
        System.out.println("=================");
        System.out.println(post.getTitle());

        post.getComments().forEach(c->{
            System.out.println("---------------");
            System.out.println(c.getComment());
        });


    }
}
