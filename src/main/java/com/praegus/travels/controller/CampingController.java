package com.praegus.travels.controller;

import com.praegus.travels.model.Camping;
import com.praegus.travels.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/campings")
public class CampingController {

    private final CampingService campingService;

    @Autowired
    public CampingController(CampingService campingService) {
        this.campingService = campingService;
    }


    @GetMapping("/all")
    public ModelAndView getAllCampings() {
        ModelAndView mav = new ModelAndView("list-campings");
        mav.addObject("campings", campingService.findAllCampings());

        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") long id) {
        Camping camping = campingService.findCampingById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid camping Id:" + id));

        ModelAndView mav = new ModelAndView("update-camping");
        mav.addObject("camping", camping);

        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView showForm(@PathVariable("id") long id) {
        Camping camping = campingService.findCampingById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid camping Id:" + id));

        ModelAndView mav = new ModelAndView("view-camping");
        mav.addObject("camping", camping);

        return mav;
    }

    @GetMapping("/new")
    public String addCampingForm(@ModelAttribute Camping camping, BindingResult result) {
        return "add-camping";
    }

    @PostMapping("/new")
    public String addCamping(@ModelAttribute Camping camping, BindingResult result) {
        campingService.saveCamping(camping);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute Camping camping,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "update-camping";
        }

        camping.setId(id);
        campingService.saveCamping(camping);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCamping(@PathVariable("id") long id) {
        campingService.findCampingById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid camping Id:" + id));
        campingService.deleteCamping(id);
        return "redirect:/";
    }

    @DeleteMapping("/delete/all")
    public String deleteAllCampings() {
        campingService.deleteAllCampings();
        return "redirect:/";
    }
}
