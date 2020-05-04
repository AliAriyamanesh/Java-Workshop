package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        String string =new String();
        System.out.println("Enter an string : ");
        string=input.next();
        countVowels(string);
    }
    public  static void countVowels(String string){
        int vowels=0;
        for(int i=0;i<string.length();i++){
            if (string.charAt(i)=='a' || string.charAt(i)=='e' || string.charAt(i)=='o' || string.charAt(i)=='u' || string.charAt(i)=='i'){
                vowels++;
            }
        }
        System.out.println("Your string includes "+vowels+" vowel sounds.");
    }
}
