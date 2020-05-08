package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Predefined accounts
        Account<String,String,Integer,Integer,AccountTypes> account1 =new Account("Ali Ariyamanesh","Mohammad",24301337,19,AccountTypes.Real,1000);
        Account<String,String,Integer,Integer,AccountTypes> account2 =new Account("Ehsan Karami","Reza",52614521,40,AccountTypes.Real,3500);
        Account<String,String,Integer,Integer,AccountTypes> account3 =new Account("Alireza Mohammadi","Ali",12369874,19,AccountTypes.Real,200);
        Account<String,String,Integer,Integer,AccountTypes> account4 =new Account("Mahdi Moosavi","Arash",32459874,25,AccountTypes.Real,1400);
        Account<String,String,Integer,Integer,AccountTypes> account5 =new Account("Amirhadi Minoofam","AghaBaba",78459612,40,AccountTypes.Real,14500);
        Account<String,String,Integer,Integer,AccountTypes> account6 =new Account("Mohammadamir Farshchi","Farshad",8514379,25,AccountTypes.Real,1200);
        Account<String,String,Integer,Integer,AccountTypes> account7 =new Account("Amirhossein Talebi","Fardad",45821722,20,AccountTypes.Real,900);
        Account<String,String,Integer,Integer,AccountTypes> account8 =new Account("Hamidreza Hozi","Hasan",85479852,20,AccountTypes.Real,11000);
        Account<String,String,Integer,Integer,AccountTypes> account9 =new Account("Azadeh Tabatabaei","Ahmad",601603755,37,AccountTypes.Real,17000);
        Account<String,String,Integer,Integer,AccountTypes> account10 =new Account("Alireza Bahrami","Abolfazl",56463128,31,AccountTypes.Real,10000);
        //-------------------
        List<Account> list= new ArrayList<>();
        list.add(account1);
        list.add(account2);
        list.add(account3);
        list.add(account4);
        list.add(account5);
        list.add(account6);
        list.add(account7);
        list.add(account8);
        list.add(account9);
        list.add(account10);

        for (Account i :list){
            i.printAccountOwner();
            i.printAccountInf();
            i.printCredit();
            i.printProfits();
            System.out.println("\n");
        }

    }
}
