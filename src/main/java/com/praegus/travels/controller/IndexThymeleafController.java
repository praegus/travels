package com.praegus.travels.controller;

import com.praegus.travels.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexThymeleafController {

    private final CampingService campingService;

    @Autowired
    public IndexThymeleafController(CampingService campingService) {
        this.campingService = campingService;
    }

    @GetMapping
    public ModelAndView getAllCampings() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("campings", campingService.findAllCampings());
        return mav;
    }
}
