package fr.idak.tutorial.ws.repository;

import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import fr.idak.tutorial.ws.config.ContextConfig;
import fr.idak.tutorial.ws.model.Book;
import fr.idak.tutorial.ws.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ContextConfig.class})
public class BookRepositoryTest {

    @Resource
    private BookRepository bookRepository;

    @Test
    public void getBook(){
        Long id = 1L;
        Book books = bookRepository.get(id);
        Assert.assertNotNull(books);
        Assert.assertThat(id, is(books.getBookId()));
    }

    @Test
    public void readAll(){
        List<Book> books = bookRepository.getAll();
        Assert.assertNotNull(books);
        Assert.assertTrue(books.size() > 0);
    }
}
