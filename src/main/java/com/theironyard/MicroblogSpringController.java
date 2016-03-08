package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * Created by vajrayogini on 3/7/16.
 */
@Controller
public class MicroblogSpringController {

    @Autowired
    MessageRepository messages;

    //ArrayList<Message> messages = new ArrayList<Message>();

    @RequestMapping(path = "/", method = RequestMethod.GET) //model only on get routes when sending to html
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("messages", messages.findAll());
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String message(HttpSession session, String text) {
        Message m = new Message(text);
        messages.save(m);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(HttpSession session, Integer id) {
        messages.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/update-message", method = RequestMethod.GET)
    public String updateMessage(Model model, int updateId) {
        Message m = messages.findOne(updateId);
        model.addAttribute("message", m);
        return "update";
    }


    @RequestMapping(path = "/update-message", method = RequestMethod.POST )
    public String updateMessage(HttpSession session, int updateId, String updatedText) {
        Message m = messages.findOne(updateId);
        m.text = updatedText;
        messages.save(m);
        return "redirect:/";


    }
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }




}
