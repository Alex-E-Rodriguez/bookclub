package com.bookclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
