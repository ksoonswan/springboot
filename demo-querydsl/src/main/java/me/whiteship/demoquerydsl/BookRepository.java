package me.whiteship.demoquerydsl;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BookRepository extends CustomRepository<Book, Long>, QuerydslPredicateExecutor<Book> {

}
