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
public class BookDaoTest {

    @Autowired
    PublisherDao publisherDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    AuthorDao authorDao;

    @Before
    public void setUp() throws Exception {
        bookDao.getAllBooks().stream().forEach(c -> bookDao.deleteBook(c.getBookID()));
        publisherDao.getAllPublisher().stream().forEach(c -> publisherDao.deletePublisher(c.getPublisherID()));
        authorDao.getAllAuthors().stream().forEach(c -> authorDao.deleteAuthor(c.getAuthorID()));

    }

    @Test
    public void addGetDeleteBook() {

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

        assertEquals(1, bookDao.getAllBooks().size());
        bookDao.deleteBook(book.getBookID());
        assertNull(bookDao.getBook(book.getBookID()));
    }

    @Test
    public void updateBook() {

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

        bookDao.addBook(book);

        book.setIsbn("12345");
        book.setPublishDate("2019/6/3");
        book.setAuthorID(author.getAuthorID());
        book.setTitle("title");
        book.setPublisherID(publisher.getPublisherID());
        book.setPrice(5.5);

        bookDao.updateBook(book);

        Book book2 = bookDao.getBook(book.getBookID());

        assertEquals(book2.getBookID(), book.getBookID());
    }

    @Test
    public void getAllBooks() {
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

        bookDao.addBook(book);


        book.setIsbn("12345");
        book.setPublishDate("2019/6/3");
        book.setAuthorID(author.getAuthorID());
        book.setTitle("title");
        book.setPublisherID(publisher.getPublisherID());
        book.setPrice(5.5);

        bookDao.addBook(book);

        assertEquals(bookDao.getAllBooks().size(), 2);
    }
}


