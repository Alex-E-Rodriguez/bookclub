package com.bookclub.web;

import com.bookclub.model.Book;
import com.bookclub.service.impl.MemBookDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    /*
     * Method with one argument, which is used to process the get request for the home page.
     * @param Model model
     * @return returns the string name for webpage ("index")
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model)
    {
        MemBookDao bookDao = new MemBookDao();
        List<Book> books = bookDao.list();
        model.addAttribute("books", books);
        return "index";
    }

    /*
     * Method with one argument, which is used to process the get request for the about page.
     * @param Model model
     * @return returns the string name for webpage ("about")
     */
    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAboutUs(Model model)
    {
        return "about";
    }

    /*
     * Method with one argument, which is used to process the get request for the contact page.
     * @param Model model
     * @return returns the string name for webpage ("contact")
     */
    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContactUs(Model model)
    {
        return "contact";
    }

    /*
     * Method with twos argument, which is used to process a webpage for a specific monthly book of a given isbn.
     * @param Model model
     * @return returns the string name for webpage ("monthly-books/view") for the ISNB string id.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model)
    {
        String isbn = id;
        System.out.println(id);

        MemBookDao bookDao = new MemBookDao();
        Book book = bookDao.find(isbn);

        System.out.println(book.toString());

        model.addAttribute("book", book);
        return "monthly-books/view";
    }
}
