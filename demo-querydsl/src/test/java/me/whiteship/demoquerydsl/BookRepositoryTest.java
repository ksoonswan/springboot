package me.whiteship.demoquerydsl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

  @Autowired
  BookRepository bookRepository;

  @Test
  public void crud(){
    Book book = new Book();
    book.setTitle("Spring");
    book.setContent("data");
    Book newBook = bookRepository.save(book);

    assertFalse(bookRepository.contains(newBook));

    Optional<Book> ring = bookRepository.findOne(QBook.book.title.contains("ring"));
    assertTrue(ring.isPresent());
  }
}