package com.example.employeedatabaseusingsqlite;

public class Employee {
    public Employee(int sno, String name, double salary) {
        this.sno = sno;
        this.name = name;
        this.salary = salary;
    }
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private int sno;
    private String name;
    private double salary;


}
