package com.praegus.travels.controller;

import com.praegus.travels.model.Camping;
import com.praegus.travels.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/campings")
public class CampingThymeleafController {

    private final CampingService campingService;

    @Autowired
    public CampingThymeleafController(CampingService campingService) {
        this.campingService = campingService;
    }

    @GetMapping("/all")
    public String getAllCampings(Model model) {
        model.addAttribute("campings", campingService.findAllCampings());
        return "list-campings";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Camping camping = campingService.findCampingById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid camping Id:" + id));
        model.addAttribute("camping", camping);
        return "update-camping";
    }

    @GetMapping("/{id}")
    public String showCampingDetails(@PathVariable("id") long id, Model model) {
        Camping camping = campingService.findCampingById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid camping Id:" + id));
        model.addAttribute("camping", camping);
        return "view-camping";
    }

    @GetMapping("/new")
    public String addCampingForm(Model model) {
        model.addAttribute("camping", new Camping());
        return "add-camping";
    }

    @PostMapping("/new")
    public String addCamping(@ModelAttribute Camping camping, BindingResult result) {
        if (result.hasErrors()) {
            return "add-camping";
        }
        campingService.saveCamping(camping);
        return "redirect:/campings/all";
    }

    @PostMapping("/update/{id}")
    public String updateCamping(@PathVariable("id") long id, @ModelAttribute Camping camping, BindingResult result) {
        if (result.hasErrors()) {
            return "update-camping";
        }
        camping.setId(id);
        campingService.saveCamping(camping);
        return "redirect:/campings/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCamping(@PathVariable("id") long id) {
        campingService.findCampingById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid camping Id:" + id));
        campingService.deleteCamping(id);
        return "redirect:/campings/all";
    }

    @GetMapping("/delete/all")
    public String deleteAllCampings() {
        campingService.deleteAllCampings();
        return "redirect:/campings/all";
    }
}
