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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoTest {

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
    public void addGetDeletePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("First");
        publisher.setStreet("street");
        publisher.setCity("city");
        publisher.setState("st");
        publisher.setPostalCode("post code");
        publisher.setEmail("publisher@publisher.com");
        publisher.setPhone("555-555-5555");

        publisherDao.addPublisher(publisher);

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

        Book book = new Book();
        book.setIsbn("12345");
        book.setPublishDate("2019/6/3");
        book.setAuthorID(author.getAuthorID());
        book.setTitle("title");
        book.setPublisherID(publisher.getPublisherID());
        book.setPrice(5.5);

        bookDao.addBook(book);

        assertEquals(publisherDao.getPublisher(publisher.getPublisherID()), publisher);

        bookDao.deleteBook(book.getBookID());
        publisherDao.deletePublisher(publisher.getPublisherID());

        assertNull(publisherDao.getPublisher(publisher.getPublisherID()));
    }

    @Test
    public void updatePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("First");
        publisher.setStreet("street");
        publisher.setCity("city");
        publisher.setState("st");
        publisher.setPostalCode("post code");
        publisher.setEmail("publisher@publisher.com");
        publisher.setPhone("555-555-5555");

        publisherDao.addPublisher(publisher);

        publisher.setName("NEWFirst");
        publisher.setStreet("NEWstreet");
        publisher.setCity("NEWcity");
        publisher.setState("ts");
        publisher.setPostalCode("NEWpost code");
        publisher.setEmail("newpublisher@publisher.com");
        publisher.setPhone("555-555-5556");

        publisherDao.updatePublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherID());

        assertEquals(publisher1.getPublisherID(), publisher.getPublisherID());
    }

    @Test
    public void getAllPublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("First");
        publisher.setStreet("street");
        publisher.setCity("city");
        publisher.setState("st");
        publisher.setPostalCode("post code");
        publisher.setEmail("publisher@publisher.com");
        publisher.setPhone("555-555-5555");

        publisherDao.addPublisher(publisher);

        publisher.setName("First");
        publisher.setStreet("st");
        publisher.setCity("city");
        publisher.setState("st");
        publisher.setPostalCode("post code");
        publisher.setEmail("publisher@publisher.com");
        publisher.setPhone("555-555-5555");

        publisherDao.addPublisher(publisher);

        assertEquals(publisherDao.getAllPublisher().size(), 2);
    }
}


