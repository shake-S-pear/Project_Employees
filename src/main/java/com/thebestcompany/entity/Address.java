package com.thebestcompany.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Embeddable
public class Address {

    @NotEmpty(message = "{NotEmpty.employeeForm.zipcode}")
    @Size(min=5, max=5, message = "{Size.employeeForm.zipcode}")
    private String zipcode;

    @NotEmpty(message = "{NotEmpty.employeeForm.city}")
    @Size(min=2, max=30, message = "{Size.employeeForm.city}")
    private String city;

    @NotEmpty(message = "{NotEmpty.employeeForm.street}")
    @Size(min=2, max=30, message = "{Size.employeeForm.street}")
    private String street;

    @NotEmpty(message = "{NotEmpty.employeeForm.building}")
    @Size(min=1, max=4, message = "{Size.employeeForm.building}")
    private String building;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

}
