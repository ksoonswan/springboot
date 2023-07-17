package me.whiteship.demojpa2.post;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findMyPost();

    void delete2(Post entity);
}
