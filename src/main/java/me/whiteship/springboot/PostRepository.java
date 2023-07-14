package me.whiteship.springboot;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PostRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Post add(Post post){
        entityManager.persist(post);
        return post;
    }

    public void delete(Post post){
        entityManager.remove(post);
    }

    public List<Post> findAll(){
        return entityManager.createQuery("SELECT p FROM Post p").getResultList();
    }
}
