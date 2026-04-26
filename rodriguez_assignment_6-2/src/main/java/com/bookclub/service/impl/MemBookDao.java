/*
    Walls, C. (2022). Spring in Action (6th ed.).
    Manning Publications Co.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2026
*/

package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

import java.util.ArrayList;
import java.util.List;

public class MemBookDao implements BookDao {

    // Instanced Variables
    private List<Book> books; // A list of books.

    /*
     * Default constructor for the MemBookDao class.
     * @return returns an instance of MemBookDao with a list of 5 books.
     */
    public MemBookDao() {
        this.books = new ArrayList<Book>();
        ArrayList<String> temp_authors = new ArrayList<String>();
        temp_authors.add("Craig Walls");
        this.books.add(new Book("9781617297571", "Spring in Action, Sixth Edition", "If you need to learn Spring, look no further than this widely beloved and comprehensive guide! Fully revised for Spring 5.3, and packed with interesting real-world examples to get your hands dirty with Spring.", 520, temp_authors));
        temp_authors.clear();
        temp_authors.add("Hannah Kent");
        this.books.add(new Book("9780316243926", "Burial Rites", "The final days of a young woman accused of murder in Iceland in 1829.", 336, temp_authors));
        temp_authors.clear();
        temp_authors.add("F. Scott Fitzgerald");
        this.books.add(new Book("9781853260414", "The Great Gatsby", "Critically acclaimed tragedy set in the 1920s about Jay Gatsby, a mysterious millionaire obsessed with reuniting with his former lover, Daisy Buchanan.", 180, temp_authors));
        temp_authors.clear();
        temp_authors.add("George R. R. Martin");
        this.books.add(new Book("9780553573404", "A Game of Thrones", "The first book in George R. R. Martin's fantasy series A Song of Ice and Fire.", 694, temp_authors));
        temp_authors.clear();
        temp_authors.add("Jane Austen");
        this.books.add(new Book("9781853260001", "Pride and Prejudice", "A novel of manners, it follows the character development of Elizabeth Bennet, the protagonist of the book, who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.", 435, temp_authors));
    } // end constructor

    @Override
    public List<Book> list() {
        return this.books;
    }

    @Override
    public Book find(String key) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }
        return new Book();
    }
}
