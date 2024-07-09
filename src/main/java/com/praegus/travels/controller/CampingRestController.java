package com.praegus.travels.controller;

import com.praegus.travels.model.Camping;
import com.praegus.travels.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/campings")
public class CampingRestController {

    private final CampingService campingService;

    @Autowired
    public CampingRestController(CampingService campingService) {
        this.campingService = campingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Camping>> getAllCampings() {
        List<Camping> campings = campingService.findAllCampings();
        return new ResponseEntity<>(campings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camping> getCampingById(@PathVariable("id") long id) {
        Camping camping = campingService.findCampingById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid camping Id:" + id));
        return new ResponseEntity<>(camping, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Camping> addCamping(@Valid @RequestBody Camping camping, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Camping savedCamping = campingService.saveCamping(camping);
        return new ResponseEntity<>(savedCamping, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Camping> updateCamping(@PathVariable("id") long id, @Valid @RequestBody Camping camping,
                                                 BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        camping.setId(id);
        Camping updatedCamping = campingService.saveCamping(camping);
        return new ResponseEntity<>(updatedCamping, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCamping(@PathVariable("id") long id) {
        campingService.findCampingById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid camping Id:" + id));
        campingService.deleteCamping(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAllCampings() {
        campingService.deleteAllCampings();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
