package com.praegus.travels.service;

import com.praegus.travels.model.Camping;
import com.praegus.travels.repository.CampingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampingService {

    private final CampingRepository campingRepository;

    @Autowired
    public CampingService(CampingRepository campingRepository) {
        this.campingRepository = campingRepository;
    }

    public List<Camping> findAllCampings() {
        return campingRepository.findAll();
    }

    public Optional<Camping> findCampingById(Long id) {
        return campingRepository.findById(id);
    }

    public Camping saveCamping(Camping camping) {
        return campingRepository.save(camping);
    }

    public void deleteCamping(Long id) {
        campingRepository.deleteById(id);
    }

    public Camping updateCamping(Long id, Camping campingDetails) {
        Camping camping = campingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Camping not found with id: " + id));

        camping.setName(campingDetails.getName());

        return campingRepository.save(camping);
    }

    public void deleteAllCampings() {
        campingRepository.deleteAll();
    }
}
