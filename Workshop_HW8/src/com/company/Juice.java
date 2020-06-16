package com.company;

public class Juice implements Category{
    private String name;
    private int price;

    public Juice(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Juice() {
    }

    @Override
    public void printData() {
        System.out.println("Category: Juice  Name: "+name+"  Price:"+Integer.toString(price));
    }
}
