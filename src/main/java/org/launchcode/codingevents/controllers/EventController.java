package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("events")
public class EventController {

    //this makes the arraylist of events accessible throughout class
//    private static List<String> events = new ArrayList<>();
    private static Map<String, String> events = new HashMap<>();
    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", events);
        events.put("Menteaship","A fun meetup for connecting with mentors");
        events.put("Code With Pride","A fun meetup sponsored by LaunchCode");
        events.put("Javascripty", "An imaginary meetup for Javascript developers");
        return "events/index";
    }
//    @PostMapping
//    public String createEventsList(Model model, @RequestParam String eventName, @RequestParam String create){
//        events.put(eventName, create);
//    return "redirect:";
//    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model){
        return "events/create";
    }
    //lives at /events/create
    //redirect: to root path for this specific controller which is /events
    @PostMapping("create")
    public String createEvent(Model model, @RequestParam String eventName, @RequestParam String eventDescription){
        events.put(eventName, eventDescription);
        return "redirect:";
    }

}
