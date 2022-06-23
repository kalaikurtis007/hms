package com.hms.dharani.web.controller;

import com.hms.dharani.persistence.entity.ProvisionalAck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;

@Controller
public class IndexController {
    @GetMapping("/home")
    public String showindex(Model model) {
        model.addAttribute("users", "kalaiselvan");
        return "index";
    }

    @GetMapping("/addProv")
    public String addProvisiong(Model model) {
        ProvisionalAck provisionalAck = new ProvisionalAck();
        //provisionalAck.setDate(new Date());
        //provisionalAck.setTime(new Time(System.currentTimeMillis()));
        model.addAttribute("provisionalAck", provisionalAck);
        return "addprovision";
    }
}
