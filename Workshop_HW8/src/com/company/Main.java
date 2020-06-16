package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Category> products;
    public static void main(String[] args) {
        products=new ArrayList<>();
        products.add(Factory.getCategory(1,1200,"apple"));
        products.add(Factory.getCategory(1,15000,"banana"));
        products.add(Factory.getCategory(1,7000,"melon"));
        products.add(Factory.getCategory(2,5000,"cucumber"));
        products.add(Factory.getCategory(2,6000,"tomato"));
        products.add(Factory.getCategory(2,4000,"latuce"));
        products.add(Factory.getCategory(3,9000,"orangejuice"));
        menu();
    }

    public static void menu() {
        System.out.println("--- Menu ---\n1-show categories\n2-show products by category\n3-add product");
        Scanner input=new Scanner(System.in);
        switch (input.next()){
            case"1":
                System.out.println("Fruits - Vegetables - Juices");
                menu();
            case "2":
                showProductsByCategory();
            case "3":
                addProduct();
        }
    }

    public static void showProductsByCategory(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter category :");
        Category temp=null;
        switch (input.next()){
            case "fruit":temp=new Fruit();
            break;
            case "vegetable":temp=new Vegetable();
            break;
            case"juice":temp=new Juice();
            break;
            default:
                System.out.println("Invalid category");
                menu();
        }
        for(Category i:products){
            if(temp!=null & i.getClass().equals(temp.getClass())){
                i.printData();
            }
        }
        menu();
    }
    public static void addProduct(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter category :");
        int i=0;
        String name="";
        int price=0;
        switch (input.next()){
            case "fruit":i=1;
            break;
            case "vegetable":i=2;
            break;
            case"juice":i=3;
            break;
            default:
                System.out.println("Invalid category");
                menu();
        }
        System.out.println("Enter product name : ");
        name=input.next();
        System.out.println("Enter product price : ");
        price=Integer.parseInt(input.next());
        System.out.println("Done");
        products.add(Factory.getCategory(i,price,name));
        menu();
    }
}
