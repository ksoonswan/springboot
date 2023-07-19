package me.whiteship.commonweb.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

  @Autowired
  PostRepository posts;

  @GetMapping("/posts/{id}")
  public String getPost(@PathVariable("id") Post post){
    return post.getTitle();
  }

  @GetMapping("/posts")
  public Page<Post> getPosts(Pageable pageable){
    return posts.findAll(pageable);
  }

  @GetMapping("/posts2")
  public PagedModel<EntityModel<Post>> getPosts2(Pageable pageable, PagedResourcesAssembler<Post> assembler){
    return assembler.toModel(posts.findAll(pageable));
  }

}
