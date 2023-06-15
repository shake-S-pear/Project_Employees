package com.thebestcompany.validator;

import com.thebestcompany.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Employee employee = (Employee) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.employeeForm.title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipcode", "NotEmpty.employeeForm.zipcode");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty.employeeForm.city");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "NotEmpty.employeeForm.street");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "building", "NotEmpty.employeeForm.building");

        if (employee.getSalary() <= 0 ) {
            errors.rejectValue("salary", "Min.employeeForm.salary");
        }

    }

}