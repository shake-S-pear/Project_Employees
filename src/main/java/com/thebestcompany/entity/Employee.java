package com.thebestcompany.entity;

import com.thebestcompany.validator.ValidEmail;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import com.thebestcompany.validator.ValidTelephoneNumber;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{NotEmpty.employeeForm.name}")
    @Size(min=2, max=30, message = "{Size.employeeForm.name}")
    private String name;

    @NotEmpty(message = "{NotEmpty.employeeForm.surname}")
    @Size(min=2, max=30, message = "{Size.employeeForm.surname}")
    private String surname;

    @NotNull
    @Valid
    private Position position;

    @NotNull
    @Valid
    private Address address;

    @NotEmpty(message = "{NotEmpty.employeeForm.email}")
    @ValidEmail(message="{ValidEmail.employeeForm.email}")
    private String email;

    @NotEmpty(message = "{NotEmpty.employeeForm.telephone}")
    @ValidTelephoneNumber(message="{ValidTelephoneNumber.employeeForm.telephone}")
    private String telephone;

    @Past(message = "{Past.employeeForm.birthdate}")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "{NotNull.employeeForm.birthdate}")
    private Date birthdate;

    public Employee() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getTitle() {
        return position.getTitle();
    }

    public int getSalary() {
        return position.getSalary();
    }

    public String getZipcode() {
        return address.getZipcode();
    }

    public String getCity() {
        return address.getCity();
    }

    public String getStreet() {
        return address.getStreet();
    }

    public String getBuilding() {
        return address.getBuilding();
    }

}
