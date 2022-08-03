package com.bikebuka.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;


    /**
     *
     * @param employeeRepository
     */
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     *
     * @return
     */
    @GetMapping("/employees")
    List<Employee> all() {
        return employeeRepository.findAll();
    }

    /**
     *
     * @param newEmployee
     * @return
     */
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));
    }

    /**
     *
     * @param newEmployee
     * @param id
     * @return
     */
    @PutMapping("/employees/{id}")
    Optional<Employee> ReplaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return Optional.of(employeeRepository
                .findById(id)
                .map(employee -> {
                    employee.setFirst_name(newEmployee.getFirst_name());
                    employee.setLast_name(newEmployee.getLast_name());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setPhone_number(newEmployee.getPhone_number());
                    employee.setEmployee_number(newEmployee.getEmployee_number());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                }));
    }

    /**
     *
     * @param id
     */
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
