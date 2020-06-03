package com.company;

public class Student {
    private int id;
    private String name;
    private String family;
    private float average;
    public Student(){}
    public Student(int id, String name, String family, float average) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.average = average;
    }

    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Student setFamily(String family) {
        this.family = family;
        return this;
    }

    public float getAverage() {
        return average;
    }

    public Student setAverage(float average) {
        this.average = average;
        return this;
    }
}
