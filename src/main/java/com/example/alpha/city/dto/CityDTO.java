package com.example.alpha.city.dto;

public class CityDTO {
    private Long CityId;
    private String name;
    private String nationality;

    public Long getCityId() {
        return CityId;
    }

    public void setCityId(Long CityId) {
        this.CityId = CityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


}