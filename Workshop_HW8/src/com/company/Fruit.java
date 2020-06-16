package com.company;

public class Fruit implements Category {
    private String name;
    private int price;
    public Fruit(){}
    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public void printData() {
        System.out.println("Category: Fruit  Name: "+name+"  Price:"+Integer.toString(price));
    }
}
