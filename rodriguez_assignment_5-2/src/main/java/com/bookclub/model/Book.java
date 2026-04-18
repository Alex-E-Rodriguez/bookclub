/*
    Walls, C. (2022). Spring in Action (6th ed.).
    Manning Publications Co.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2026
*/

package com.bookclub.model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    // Instanced Variables
    private String isbn; // Book ISBN. Default empty string.
    private String title; // Book Title. Default empty string.
    private String description; // Book Description. Default empty string.
    private int numOfPages; // Book Page Count. Default zero.
    private List<String> authors; // Book authors. Default empty List of strings.

    /*
     * Default constructor for the Book class.
     * @return returns an instance of Book with no isbn, title, description, page count, or author list.
     */
    public Book() {
        this.isbn = "";
        this.title = "";
        this.description = "";
        this.numOfPages = 0;
        this.authors = new ArrayList<String>();
    } // end constructor

    /*
     * Overloaded constructor for the Book class.
     * @param isbn string
     * @param title string
     * @param description string
     * @param numOfPages int
     * @param List<String> authors
     * @return returns an instance of Book with a user-specified isbn, title, description, page count, or author list.
     */
    public Book(String isbn, String title, String description, int numOfPages, List<String> authors)
    {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.numOfPages = numOfPages;
        this.authors = authors;
    } // end constructor

    /*
     * Method with no arguments, which is used as an accessor for the book's ISBN.
     * @return the book's current ISBN as a string
     */
    public String getIsbn()
    {
        return this.isbn;
    } // end getIsbn

    /*
     * Method with one argument, which is used as a mutator for the book's ISBN.
     * @param isbn String
     */
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    } // end setIsbn

       /*
     * Method with no arguments, which is used as an accessor for the book's title.
     * @return the book's current title as a string
     */
    public String getTitle()
    {
        return this.title;
    } // end getTitle

    /*
     * Method with one argument, which is used as a mutator for the book's title.
     * @param title String
     */
    public void setTitle(String title)
    {
        this.title = title;
    } // end setTitle

    /*
     * Method with no arguments, which is used as an accessor for the book's description.
     * @return the book's current description as a string
     */
    public String getDescription()
    {
        return this.description;
    } // end getDescription

    /*
     * Method with one argument, which is used as a mutator for the book's description.
     * @param description String
     */
    public void setDescription(String description)
    {
        this.description = description;
    } // end setDescription

    /*
     * Method with no arguments, which is used as an accessor for the book's numOfPages.
     * @return the book's current numOfPages as an int
     */
    public int getNumOfPages()
    {
        return this.numOfPages;
    } // end getNumOfPages

    /*
     * Method with one argument, which is used as a mutator for the book's numOfPages.
     * @param numOfPages int
     */
    public void setNumOfPages(int numOfPages)
    {
        this.numOfPages = numOfPages;
    } // end setNumOfPages

    /*
     * Method with no arguments, which is used as an accessor for the book's authors.
     * @return the book's current authors as a string
     */
    public List<String> getAuthors()
    {
        return this.authors;
    } // end getAuthors

    /*
     * Method with one argument, which is used as a mutator for the book's authors.
     * @param authors List<String>
     */
    public void setAuthors(List<String> authors)
    {
        this.authors = authors;
    } // end setAuthors

    /*
     * Override method to output the current Book.
     * @return returns a String that reports the Book's ISBN, title, description, number of pages, and authors.
     */
    @Override public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
            String.format("Book{isbn=%1$s, title=%2$s, description=%3$s, numOfPages=%4$s, authors=", isbn, title, description, numOfPages)
        );
        stringBuilder.append(String.join(", ", authors));
        stringBuilder.append("}");
        return stringBuilder.toString();
    } // end toString

}
