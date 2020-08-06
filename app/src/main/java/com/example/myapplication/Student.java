package com.example.myapplication;

public class Student {
    private String name;
    private double age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, double age) {
        this.name = name;
        this.age = age;
    }
}
