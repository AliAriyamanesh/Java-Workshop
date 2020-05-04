package com.company;

import java.util.*;

public class Main {



    public static void main(String[] args) {
        // Predefined transporters
       Transporter[] transporter=new Transporter[9];
       transporter[0]=new Car("Ali Ariyamanesh",32,PredefinedPaths.Poonak , 3 ,12000,VehicleModels.Pride);
       transporter[1]=new Car("Amirhadi Minoofam",40,PredefinedPaths.Tajrish , 4 ,18000,VehicleModels.Peugeot_Pars);
       transporter[2]=new Car("Amirmohammad Farshchi",25,PredefinedPaths.Marzdaran, 4 ,10000,VehicleModels.Samand);
       transporter[3]=new Bus("Mohsen kafaei",35,PredefinedPaths.Poonak , 45 ,1200,VehicleModels.Benz);
       transporter[4]=new Bus("Reza Keyvani",43,PredefinedPaths.Tajrish , 42 ,2000,VehicleModels.Scania);
       transporter[5]=new Bus("Hossein Mardani",39,PredefinedPaths.Marzdaran , 30 ,1000,VehicleModels.Volvo);
       transporter[6]=new Van("Ali Ansari",40,PredefinedPaths.Poonak , 15 ,3000,VehicleModels.Delica);
       transporter[7]=new Van("Homayoun Izadparast",49,PredefinedPaths.Tajrish , 12 ,5000,VehicleModels.Mitsubishi_caspian);
       transporter[8]=new Van("Ahmad Moosavi",49,PredefinedPaths.Marzdaran , 18 ,2000,VehicleModels.Kia_Carnaval);
       //**************************
        Scanner input=new Scanner(System.in);
        String name=null;
        PredefinedPaths path=null;
        VehicleType typechoice = null;
        int choice;

        System.out.println("Enter Your name : ");
        try {
           name=getName(input);
        }catch (NameException ex){
            ex.printStackTrace();
        }

        System.out.println("Choose vehicle type : \n1) Car\n2) Bus\n3) Van");
        choice=Integer.parseInt(input.next());
        switch (choice){
            case 1:
                typechoice=VehicleType.car;
                break;
            case 2:
                typechoice=VehicleType.bus;
                break;
            case 3:
                typechoice=VehicleType.van;
                break;
        }
        System.out.println("Enter your path (Poonak,Tajrish,Marzdaran) :");
        try {
            path=getPath(input);
        } catch (PathException e) {
            e.printStackTrace();
        }
        Map search_result = new HashMap();
        int n=1;
        for (int i=0;i<9;i++) {
            if (transporter[i].path == path && transporter[i].Type == typechoice) {
                search_result.put(n, transporter[i]);
                n++;
            }
        }
        System.out.println("Choose a driver : ");
        Transporter temp=new Transporter();
        for(int i=1;i<n;i++ ){
            temp=(Transporter) search_result.get(i);
            System.out.println(i+")Name: "+ temp.name+"  Age: "+temp.age+"  Vehicle: " +temp.model+"  Passengers :"+temp.passengers+"  Price :"+temp.price);
        }
        choice = Integer.parseInt(input.next());
        temp=(Transporter) search_result.get(choice);
        System.out.println("Well done !\nTransporter reserved " +
                "\nPassenger name : "+name+"\nDriver name : "+temp.name);
    }

    public static String getName(Scanner input) throws NameException {
        String name=null;
        name=input.nextLine();
        for(int i=0;i<name.length();i++){
            if ((name.charAt(i)<65 || name.charAt(i)>90)&&(name.charAt(i)<97 || name.charAt(i)>122)&&name.charAt(i)!=95){
                throw new NameException("Name contains unauthorized character !");
            }
        }
        return name;
    }
    public static PredefinedPaths getPath(Scanner input) throws PathException{
        PredefinedPaths path=null;
        switch (input.next()){
            case "Poonak":
                path=PredefinedPaths.Poonak;
                break;
            case "Tajrish":
                path=PredefinedPaths.Tajrish;
                break;
            case "Marzdaran":
                path=PredefinedPaths.Marzdaran;
                break;
            default:
                throw new PathException("Unauthorized Path !");
        }
        return path;

    }
}
