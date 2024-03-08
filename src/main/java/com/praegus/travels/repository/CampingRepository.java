package com.praegus.travels.repository;

import com.praegus.travels.model.Camping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampingRepository extends JpaRepository<Camping, Long> {
    // You can add custom query methods here if needed
}
