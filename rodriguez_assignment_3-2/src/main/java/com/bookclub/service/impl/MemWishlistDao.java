/*
    Walls, C. (2022). Spring in Action (6th ed.).
    Manning Publications Co.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2026
*/

package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import java.util.ArrayList;
import java.util.List;

public class MemWishlistDao implements WishlistDao {
    // Instanced Variables
    private List<WishlistItem> wishlist; // A list of books.

    /*
     * Default constructor for the MemBookDao class.
     * @return returns an instance of MemBookDao with a list of 5 books.
     */
    public MemWishlistDao() {
        this.wishlist = new ArrayList<WishlistItem>();
        this.wishlist.add(new WishlistItem("9780544003415", "The Lord of the Rings "));
        this.wishlist.add(new WishlistItem("9780385490818", "The Handmaid's Tale"));
        this.wishlist.add(new WishlistItem("9781853260001", "Pride and Prejudice"));
    } // end constructor

    @Override
    public List<WishlistItem> list() {
        return this.wishlist;
    }

    @Override
    public WishlistItem find(String key) {
        for (WishlistItem item : this.wishlist) {
            if (item.getIsbn().equals(key)) {
                return item;
            }
        }
        return new WishlistItem();
    }
}
