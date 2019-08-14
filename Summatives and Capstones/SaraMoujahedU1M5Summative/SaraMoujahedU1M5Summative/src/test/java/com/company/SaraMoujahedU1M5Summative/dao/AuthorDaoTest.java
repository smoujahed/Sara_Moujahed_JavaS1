package com.company.SaraMoujahedU1M5Summative.dao;

import com.company.SaraMoujahedU1M5Summative.model.Author;
import com.company.SaraMoujahedU1M5Summative.model.Book;
import com.company.SaraMoujahedU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {

    @Autowired
    PublisherDao publisherDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    AuthorDao authorDao;

    @Before
    public void setUp() throws Exception {
        bookDao.getAllBooks().stream().forEach(c -> bookDao.deleteBook(c.getBookID()));
        authorDao.getAllAuthors().stream().forEach(c -> authorDao.deleteAuthor(c.getAuthorID()));
        publisherDao.getAllPublisher().stream().forEach(c -> publisherDao.deletePublisher(c.getPublisherID()));
    }

    @Test
    public void addGetDeleteAuthor() {

        Author author = new Author();
        author.setFirstName("First");
        author.setLastName("Last");
        author.setStreet("street");
        author.setCity("city");
        author.setState("st");
        author.setPostalCode("post code");
        author.setEmail("author@author.com");
        author.setPhone("555-555-5555");
        author = authorDao.addAuthor(author);


        Publisher publisher = new Publisher();
        publisher.setName("First");
        publisher.setStreet("street");
        publisher.setCity("city");
        publisher.setState("st");
        publisher.setPostalCode("post code");
        publisher.setEmail("publisher@publisher.com");
        publisher.setPhone("555-555-5555");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("12345");
        book.setPublishDate("2019/6/3");
        book.setAuthorID(author.getAuthorID());
        book.setTitle("title");
        book.setPublisherID(publisher.getPublisherID());
        book.setPrice(5.5);
        book = bookDao.addBook(book);



        assertEquals(authorDao.getAuthor(author.getAuthorID()), author);

        bookDao.deleteBook(book.getBookID());
        publisherDao.deletePublisher(publisher.getPublisherID());
        authorDao.deleteAuthor(author.getAuthorID());

        assertNull(authorDao.getAuthor(author.getAuthorID()));
    }

    @Test
    public void updateAuthorTest() {


        Author author = new Author();
        author.setFirstName("First");
        author.setLastName("Last");
        author.setStreet("street");
        author.setCity("city");
        author.setState("ts");
        author.setPostalCode("post code");
        author.setPhone("555-555-5555");
        author.setEmail("email");

        authorDao.addAuthor(author);

        author.setFirstName("NEWFirst");
        author.setLastName("NEWLast");
        author.setStreet("NEWstreet");
        author.setCity("NEWcity");
        author.setState("st");
        author.setPostalCode("NEWpost code");
        author.setPhone("555-555-5556");
        author.setEmail("new@author.com");


        authorDao.updateAuthor(author);

        assertEquals(authorDao.getAuthor(author.getAuthorID()), author);
    }

    @Test
    public void getAllAuthorsTest() {

        Author author = new Author();
        author.setFirstName("First");
        author.setLastName("Last");
        author.setStreet("street");
        author.setCity("city");
        author.setState("st");
        author.setPostalCode("post code");
        author.setEmail("author@author.com");
        author.setPhone("555-555-5555");

        authorDao.addAuthor(author);

        author.setFirstName("NEWFirst");
        author.setLastName("NEWLast");
        author.setStreet("NEWstreet");
        author.setCity("NEWcity");
        author.setState("ts");
        author.setPostalCode("NEWpost code");
        author.setPhone("555-555-5556");
        author.setEmail("new@author.com");
        authorDao.addAuthor(author);

        assertEquals(authorDao.getAllAuthors().size(), 2);
    }
}


