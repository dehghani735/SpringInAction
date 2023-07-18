package com.mdt.FunctionalAndReactive.M12_Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private char gender;
    private Date dob;
    private String city;
    private String designation;
    private Date joiningDate;
    private double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", city='" + city + '\'' +
                ", designation='" + designation + '\'' +
                ", joiningDate=" + joiningDate +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if (this.id < o.id)
            return -1;
        else if (this.id > o.id)
            return 1;
        else return 0;
    }
}
