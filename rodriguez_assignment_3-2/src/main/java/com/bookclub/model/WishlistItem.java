/*
    Walls, C. (2022). Spring in Action (6th ed.).
    Manning Publications Co.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2026
*/

package com.bookclub.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class WishlistItem {

    // Instanced Variables
    @NotNull
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn; // Book ISBN. Default empty string.
    @NotNull
    @NotEmpty(message = "Title is a required field.")
    private String title; // Book Title. Default empty string.

    /*
     * Default constructor for the WishlistItem class.
     * @return returns an instance of WishlistItem with no isbn or title.
     */
    public WishlistItem() {
        this.isbn = "";
        this.title = "";
    } // end constructor

    /*
     * Overloaded constructor for the WishlistItem class.
     * @param isbn string
     * @param title string
     * @return returns an instance of Book with a user-specified isbn and title.
     */
    public WishlistItem(String isbn, String title)
    {
        this.isbn = isbn;
        this.title = title;
    } // end constructor

    /*
     * Method with no arguments, which is used as an accessor for the wishlist item's ISBN.
     * @return the wishlist item's current ISBN as a string
     */
    public String getIsbn()
    {
        return this.isbn;
    } // end getIsbn

    /*
     * Method with one argument, which is used as a mutator for the wishlist item's ISBN.
     * @param isbn String
     */
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    } // end setIsbn

    /*
     * Method with no arguments, which is used as an accessor for the wishlist item's title.
     * @return the wishlist item's current title as a string
     */
    public String getTitle()
    {
        return this.title;
    } // end getTitle

    /*
     * Method with one argument, which is used as a mutator for the wishlist item's title.
     * @param title String
     */
    public void setTitle(String title)
    {
        this.title = title;
    } // end setTitle

    /*
     * Override method to output the current WishlistItem.
     * @return returns a String that reports the WishlistItem's ISBN and title.
     */
    @Override public String toString()
    {
        return String.format("WishlistItem{isbn=%1$s, title=%2$s}", isbn, title);
    } // end toString


}
