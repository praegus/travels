package com.praegus.travels.controller;

import com.github.javafaker.Faker;
import com.praegus.travels.model.Camping;
import com.praegus.travels.service.CampingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/settings")
public class SettingsRestController {

    private final CampingService campingService;

    @Autowired
    public SettingsRestController(CampingService campingService) {
        this.campingService = campingService;
    }

    @PostMapping("/generate")
    public ResponseEntity<Void> generateCampings(@RequestParam("amount") int amount) {

        Faker faker = new Faker(new Locale("nl-NL"));

        for (int i = 0; i < amount; i++) {
            Camping camping = new Camping();
            camping.setName("Camping " + StringUtils.capitalize(faker.animal().name()));
            camping.setDescription(faker.lorem().paragraph(5));
            camping.setStars(faker.number().numberBetween(1, 5));
            camping.setPrice(faker.number().randomDouble(2, 50, 200));
            campingService.saveCamping(camping);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
