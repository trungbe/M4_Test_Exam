package com.example.exam.model;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 30, message = "Nhập ít nhất từ 2 to 30 kí tự ! ")
    private String name;

    @NotNull(message = "Mời nhập diện tích !")
    private Integer totalArea;

    @NotNull(message = "Mời nhập dân số !")
    private Long population;

    @NotNull(message = "Mời nhập bình quân đầu người !")
    private Integer gdp;

    @NotEmpty(message = "Mời nhập mô tả !")
    private String description;

    @ManyToOne
    private Country country;

    public City() {
    }

    public City(Long id, @Size(min = 2, max = 30, message = "Nhập ít nhất từ 2 to 30 kí tự ! ") String name, @NotNull(message = "Mời nhập diện tích !") Integer totalArea, @NotNull(message = "Mời nhập dân số !") Long population, @NotNull(message = "Mời nhập bình quân đầu người !") Integer gdp, @NotEmpty(message = "Mời nhập mô tả !") String description, Country country) {
        this.id = id;
        this.name = name;
        this.totalArea = totalArea;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Integer getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Integer totalArea) {
        this.totalArea = totalArea;
    }

    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
