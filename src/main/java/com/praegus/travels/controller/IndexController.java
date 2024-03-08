package com.praegus.travels.controller;

import com.praegus.travels.service.CampingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class IndexController {

    private final CampingService campingService;

    public IndexController(CampingService campingService) {
        this.campingService = campingService;
    }

    @GetMapping
    public ModelAndView getAllCampings() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("campings", campingService.findAllCampings());

        return mav;
    }
}