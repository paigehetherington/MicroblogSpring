package com.theironyard;

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

    ArrayList<Message> messages = new ArrayList<Message>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("messages", messages);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String message(Model model, String text) {
        Message m = new Message(messages.size() + 1, text);
        messages.add(m);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(Model model, int id) {
        messages.remove(id-1);
        return "redirect:/";
    }



}
