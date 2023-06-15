package com.thebestcompany.controller;

import com.thebestcompany.entity.Employee;
import com.thebestcompany.service.EmployeeService;
import com.thebestcompany.validator.EmployeeFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeFormValidator employeeFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(employeeFormValidator);
    }

    @RequestMapping(value={"/employee/", "/employee/list"})
    public String viewHomePage(Model model) {
        return viewPage(model, 1, "name", "asc");
    }

    @RequestMapping("/employee/list/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum,
                           @Param("sortField") String sortField,
                           @Param("sortDir") String sortDir) {

        Page<Employee> page = employeeService.listAll(pageNum, sortField, sortDir);

        List<Employee> employees = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalEmployees", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("employees", employees);

        return "list-employees";
    }

    @GetMapping("/employee/showForm")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employeeForm", employee);
        return "employee-form";
    }

    @PostMapping("/employee/saveEmployee")
    public String saveEmployee(@ModelAttribute("employeeForm") @Validated Employee employee,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "employee-form";
        } else {

            employeeService.save(employee);
            return "redirect:/employee/";
        }
    }

    @GetMapping("/employee/updateForm")
    public String showFormForUpdate(@RequestParam("employeeId") Long id, Model model) {
        Employee employee = employeeService.get(id);
        model.addAttribute("employeeForm", employee);
        return "employee-form";
    }

    @GetMapping("/employee/delete")
    public String deleteEmployee(@RequestParam("employeeId") Long id) {
        employeeService.delete(id);
        return "redirect:/employee/";
    }

}
