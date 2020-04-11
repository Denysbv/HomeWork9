package com.SoftServAcademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class MyThread extends java.lang.Thread {
    int pause;
    String msg;
    int iteration;

    public MyThread(int pause, String msg, int iteration) {
        this.pause = pause;
        this.msg = msg;
        this.iteration = iteration;
    }

    public void run() {
        for (int i = 0; i<iteration; i++) {
            try {
                sleep(pause);
                System.out.println(msg);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }
}

class Run1 implements Runnable{
    @Override
    public void run() {
        for (int i =0; i<5; i++) {
            System.out.println("Run1 message number " + (i+1));
        }
    }
}
class Run2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Run2 message number " + (i+1));
        }
    }
}
class Run3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Run3 message number " + (i+1));
        }
    }
}
public class Main {

    public static void main(String[] args) throws InterruptedException {
        //#1
        MyThread myThread1 = new MyThread(1000, "I study Java", 10);
        myThread1.run();

        //#2
        MyThread myThread2 = new MyThread(2000, "Hello World", 5);
        MyThread myThread3 = new MyThread(3000, "Peace in peace", 5);
        myThread2.start();
        myThread3.start();
        myThread2.join();
        myThread3.join();
        System.out.println("My name is Denys");

        //#3
        Thread t1 = new Thread(new Run1());
        Thread t2 = new Thread(new Run2());
        Thread t3 = new Thread(new Run3());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }
        t3.start();

        //#4
        List <String > myList = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader ("/Users/denysborysenko/Desktop/JavaPrograms/HomeWork9/src/com/SoftServAcademy/The_Three_Body_Problem.txt.txt"))){
            while (br.readLine() != null) {
                myList.add(br.readLine());
            }
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println(myList.size());

        //убираю пустые
        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("")) {
                iterator.remove();
            }
        }
        System.out.println(myList.size());

        for (int i =0; i<myList.size(); i++) {
            System.out.println(myList.get(i).length()); // 1
        }
        int min = Integer.MAX_VALUE; // 2
        int max = Integer.MIN_VALUE;
        int indMin = 0;
        int indMax = 0;
        for (int i =0; i<myList.size(); i++) {
            if (myList.get(i).length()<min) {
                min = myList.get(i).length();
                indMin = i;
            } if (myList.get(i).length()>max) {
                max = myList.get(i).length();
                indMax = i;
            }
        }
        System.out.println("Shortest line is " + (indMin+1) + " with " + myList.get(indMin).length() + " characters");
        System.out.println("Longest line is " + (indMax+1) + " with " + myList.get(indMax).length() + " characters");

        String var = "var";
        for (int i = 0; i< myList.size(); i++) {
            if (myList.get(i).equals(var)) {
                System.out.println("Line " + (i+1) + " consist of word «var»");
            }
        }
        for (int i = 0; i<myList.size(); i++) {
            System.out.println(i + " - " + myList.get(i));
        }
    }
}

