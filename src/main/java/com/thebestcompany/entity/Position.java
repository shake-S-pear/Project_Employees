package com.thebestcompany.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;

@Embeddable
public class Position {

    @NotEmpty(message = "{NotEmpty.employeeForm.title}")
    @Size(min=2, max=30, message = "{Size.employeeForm.title}")
    private String title;

    @Min(value = 1, message = "{Min.employeeForm.salary}")
    private int salary;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
