package com.praegus.travels.controller;

import com.praegus.travels.model.Camping;
import com.praegus.travels.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IndexRestController {

    private final CampingService campingService;

    @Autowired
    public IndexRestController(CampingService campingService) {
        this.campingService = campingService;
    }

    @GetMapping("/campings")
    public ResponseEntity<List<Camping>> getAllCampings() {
        List<Camping> campings = campingService.findAllCampings();
        return new ResponseEntity<>(campings, HttpStatus.OK);
    }
}
