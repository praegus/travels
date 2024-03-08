package com.praegus.travels;

import com.praegus.travels.model.Camping;
import com.praegus.travels.repository.CampingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private CampingRepository campingRepository;

    @Autowired
    public void DataLoader(CampingRepository campingRepository) {
        this.campingRepository = campingRepository;
    }

    public void run(ApplicationArguments args) {

        Camping zeezicht = new Camping();
        zeezicht.setName("Camping Zeezicht");
        zeezicht.setDescription("Mooie camping gelegen aan de zee.");
        zeezicht.setStars(5);
        zeezicht.setPrice(100.00);
        campingRepository.save(zeezicht);

        Camping parkweide = new Camping();
        parkweide.setName("Camping Parkweide");
        parkweide.setDescription("Mooie camping gelegen aan een park.");
        parkweide.setStars(5);
        parkweide.setPrice(100.00);
        campingRepository.save(parkweide);

        Camping zonzicht = new Camping();
        zonzicht.setName("Camping Zonzicht");
        zonzicht.setDescription("Mooie camping gelegen aan de zee.");
        zonzicht.setStars(5);
        zonzicht.setPrice(100.00);
        campingRepository.save(zonzicht);
    }
}