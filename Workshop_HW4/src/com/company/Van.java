package com.company;

public class Van extends Transporter {


    public Van(String name, int age, PredefinedPaths path, int passengers, int price, VehicleModels model){
        this.name = name;
        this.age = age;
        this.path = path;
        this.passengers = passengers;
        this.price = price;
        this.model=model;
        Type = VehicleType.van;
    }
}
