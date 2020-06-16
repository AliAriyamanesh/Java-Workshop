package com.company;

public class Factory {
    public static Category getCategory(int i , int price,String name){
        switch (i){
            case 1:return new Fruit(name,price);

            case 2:return new Vegetable(name,price);

            case 3:return new Juice(name,price);

        }
        return null;
    }
}
