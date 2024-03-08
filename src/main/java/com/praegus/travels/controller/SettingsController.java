package com.praegus.travels.controller;

import com.github.javafaker.Faker;
import com.praegus.travels.model.Camping;
import com.praegus.travels.service.CampingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@RestController
@RequestMapping("/settings")
public class SettingsController {

    private final CampingService campingService;

    public SettingsController(CampingService campingService) {
        this.campingService = campingService;
    }

    @GetMapping
    public ModelAndView showSettings() {
        return new ModelAndView("settings");
    }

    @PostMapping("/generate")
    public ModelAndView generate(@RequestParam("amount") int amount) {

        Faker faker = new Faker(new Locale("nl-NL"));

        for (int i = 0; i < amount; i++) {
            Camping camping = new Camping();
            camping.setName("Camping " + StringUtils.capitalize(faker.animal().name()));
            camping.setDescription(faker.lorem().paragraph(5));
            camping.setStars(faker.number().numberBetween(1, 5));
            camping.setPrice(faker.number().randomDouble(2, 50, 200));
            campingService.saveCamping(camping);
        }

        return new ModelAndView("index");
    }
}