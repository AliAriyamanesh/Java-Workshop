package com.company;

public class Vegetable implements Category {
    private String name;
    private int price;

    public Vegetable(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Vegetable() {
    }

    @Override
    public void printData() {
        System.out.println("Category: Vegetable  Name: "+name+"  Price:"+Integer.toString(price));
    }
}
