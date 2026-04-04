/*
    Walls, C. (2022). Spring in Action (6th ed.).
    Manning Publications Co.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2026
*/

package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.impl.MemWishlistDao;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    /*
     * Method with one argument, which is used to process the get request for the wishlist/list page.
     * @param Model model
     * @return returns the string name for webpage ("list")
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model) {
        MemWishlistDao memWishlistDao = new MemWishlistDao();
        List<WishlistItem> wishlist = memWishlistDao.list();
        model.addAttribute("wishlist", wishlist);
        return "wishlist/list";
    }

    /*
     * Method with one argument, which is used to process the get request for the wishlist/new page.
     * @param Model model
     * @return returns the string name for webpage ("new")
     */
    @RequestMapping(method = RequestMethod.GET, path = "/new")
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    }

    /*
     * Method with one argument, which is used to process the post request for a new wishlist item (redirecting if errors exist in submission).
     * @param Model model
     * @return returns the string name for webpage ("new" or "wishlist")
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult) {
        System.out.println(wishlistItem.toString());
        System.out.println((bindingResult.getAllErrors()));
        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        return "redirect:/wishlist";
    }
}
