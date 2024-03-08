package com.praegus.travels.model;

//import jakarta.persistence.*;

import javax.persistence.*;

@Entity
public class Camping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private Integer stars;

    private Double price;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Camping() {
    }

    public Camping(Long id, String name, String location, Integer stars, Double price, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.stars = stars;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Optionally, override toString, equals, and hashCode methods
}