package com.bikebuka.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {
    private @Id @GeneratedValue Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String employee_number;
    private String phone_number;

    Employee(){}

    Employee(String first_name,
             String last_name,
             String email,
             String employee_number,
             String phone_number
    ) {
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.employee_number=employee_number;
        this.phone_number=phone_number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setEmployee_number(String employee_number) {
        this.employee_number = employee_number;
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getEmployee_number() {
        return employee_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }

        Employee employee= (Employee) o;
        return Objects.equals(this.id,employee.id) &&
                Objects.equals(this.email,employee.email) &&
                Objects.equals(this.employee_number,employee.employee_number) &&
                Objects.equals(this.first_name, employee.first_name) &&
                Objects.equals(this.last_name, employee.last_name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.first_name,this.last_name,this.email, this.phone_number,this.employee_number);
    }
    @Override
    public String toString(){
        return "Employee{" + "id=" + this.id +
                ", First Name='" + this.first_name +
                '\'' + ", Last Name='" + this.last_name +
                '\'' + ", Email='" + this.email +
                '\'' + ", Phone Number='" + this.phone_number +
                '\'' + ", Employee Number='" + this.employee_number +
                '\'' + '}';
    }
}
