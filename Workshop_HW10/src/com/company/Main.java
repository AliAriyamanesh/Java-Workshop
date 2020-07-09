package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<DocumentEntity> list = new ArrayList<>();
        List<DocumentEntity> sublist = new ArrayList<>();
        list=catchDocList();
        Thread[] threads = new Thread[list.size()%5 + 1];
        int j = 0;
        for (int i =0 ; i<list.size() ; i++){
            if ((i%5 == 0 & sublist.size() > 0) | (i==list.size()-1)){
                MyThread myThread = new MyThread(sublist);
                threads[j] = new Thread(myThread);
                threads[j].run();
                try {
                    threads[j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sublist.clear();
                j++;
                System.out.println("Done");
            }else{
                sublist.add(list.get(i));
            }
        }
    }
    public static List<DocumentEntity> catchDocList(){
        List<DocumentEntity> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
     while (true){
         System.out.println("*** Menu ***\n1-add document\n2-store documents ");
         switch (Integer.parseInt(input.next())){
             case 1:
                 DocumentEntity entity=new DocumentEntity();
                 System.out.println("id :");
                 entity.setId(Integer.parseInt(input.next()));
                 System.out.println("title :");
                 entity.setTitle(input.next());
                 System.out.println("context :");
                 entity.setContext(input.next());
                 list.add(entity);
                 break;
             case 2:
                 return list;
         }
        }
    }
}
