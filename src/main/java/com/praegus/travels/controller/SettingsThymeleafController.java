package com.praegus.travels.controller;

import com.github.javafaker.Faker;
import com.praegus.travels.model.Camping;
import com.praegus.travels.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@RequestMapping("/settings")
public class SettingsThymeleafController {

    private final CampingService campingService;

    @Autowired
    public SettingsThymeleafController(CampingService campingService) {
        this.campingService = campingService;
    }

    @GetMapping
    public ModelAndView showSettings() {
        return new ModelAndView("settings");
    }

    @PostMapping("/generate")
    public ModelAndView generateCampings(@RequestParam("amount") int amount) {

        Faker faker = new Faker(new Locale("nl-NL"));

        for (int i = 0; i < amount; i++) {
            Camping camping = new Camping();
            camping.setName("Camping " + StringUtils.capitalize(faker.animal().name()));
            camping.setDescription(faker.lorem().paragraph(5));
            camping.setStars(faker.number().numberBetween(1, 5));
            camping.setPrice(faker.number().randomDouble(2, 50, 200));
            campingService.saveCamping(camping);
        }

        return new ModelAndView("redirect:/");
    }
}
