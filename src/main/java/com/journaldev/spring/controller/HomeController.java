package com.journaldev.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.User;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model , HttpServletRequest request) {
        System.out.println("Home Page Requested, locale = " + locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(@Validated User user, Model model) {
        System.out.println("User Page Requested");
        model.addAttribute("userName", user.getUserName());
        return "user";
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(HttpServletRequest request, @RequestParam String s,@RequestParam int a) {
        // http://localhost:8080/SpringMVC/test?s=123&a=2
        System.out.println(request.getScheme());
        System.out.println(request.getServletPath());
        System.out.println(request.getContextPath());
        System.out.println(request.getServerName());
        System.out.println(request.getServerPort());
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println("User Page Requested");
        return "home";
    }
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2(User user) {
        return "home";
    }
    @RequestMapping(value = "/post_form", method = RequestMethod.POST)
    public String post_form(User user) {
        return "home";
    }
    @RequestMapping(value = "/post_json", method = RequestMethod.POST,consumes = {"application/json"})
    public String post_json(@RequestBody User user) {
        return "home";
    }
}
