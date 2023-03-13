package edu.wctc.gameclub.controller;

import edu.wctc.gameclub.service.EventService;
import edu.wctc.gameclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private EventService eventService;
    @Autowired
    private MemberService memberService;

    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("memberList", memberService.getAllMembers());
        model.addAttribute("eventList", eventService.getAllEvents());
        return "index";
    }
}
