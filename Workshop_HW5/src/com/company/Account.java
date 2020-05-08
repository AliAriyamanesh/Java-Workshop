package com.company;

public class Account <Name,Father,Mellicode,Age,AccountType> {
    private Name name;
    private Father father;
    private Mellicode mellicode;
    private Age age;
    private AccountType accountType;
    private int credit;
    public Account(Name name, Father father, Mellicode mellicode, Age age, AccountType accountType,int credit) {
        this.name = name;
        this.father = father;
        this.mellicode = mellicode;
        this.age = age;
        this.accountType = accountType;
        this.credit=credit;
    }
    public Account() {
    }
    public void printCredit(){
        System.out.println("Credit : "+credit+"$");
    }
    public void printProfits(){
        System.out.println("Monthly profits : "+(credit * 0.03)+"$");
    }
    public void printAccountInf(){
        System.out.println("AccountType : "+accountType);
    }
    public void printAccountOwner(){
        System.out.println("Name : "+name+" Father : "+father+" Mellicode : "+mellicode+" Age : "+age);
    }
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public Mellicode getMellicode() {
        return mellicode;
    }

    public void setMellicode(Mellicode mellicode) {
        this.mellicode = mellicode;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
