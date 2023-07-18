package me.whiteship.demojpa2.post;

import me.whiteship.demojpa2.MyRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends MyRepository<Post, Long>, QuerydslPredicateExecutor<Post> {

}
