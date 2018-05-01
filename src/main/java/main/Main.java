package main;

import core.ArrayList;
import core.DoubleLinkedList;
import core.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("ARRAY LIST TEST");
        listInsertTest(new ArrayList<Integer>());
        System.out.println("/n/n/nDoubleLinkedListTest");
        listInsertTest(new DoubleLinkedList<Integer>());

        System.out.println("ARRAY LIST TEST");
        deleteTest(new ArrayList<Integer>());
        System.out.println("/n/n/nDoubleLinkedListTest");
        deleteTest(new DoubleLinkedList<Integer>());
    }

    private static void listInsertTest(List<Integer> list) {
        long startTime;
        long endTime;
        long averageTime = 0;
        List<Integer> test = list;
/*
        Elemente vorne in die Liste einfügen
 */
        for (int i = 0; i < 10; i++) {
            startTime = System.currentTimeMillis();
            for (int j = 0; j < 20000; j++) {
                test.insert(1, 0);
            }
            endTime = System.currentTimeMillis();
            test.clear();
            System.out.println(endTime - startTime);
            averageTime += (endTime - startTime);
        }
        /*
        Elemente mittig in die Liste einfügen

         */

        System.out.println("Avarage Time inserting front: " + averageTime / 10);
        averageTime = 0;
        for (int i = 0; i < 10; i++) {
            startTime = System.currentTimeMillis();
            for (int j = 0; j < 20000; j++) {
                test.insert(1, j % 2);
            }
            endTime = System.currentTimeMillis();
            test.clear();
            System.out.println(endTime - startTime);
            averageTime += (endTime - startTime);
        }

        System.out.println("Avarage Time inserting mid: " + averageTime / 10);
        averageTime = 0;


        /*
        Elemente Hinten in die Liste einfügen
         */
        for (int i = 0; i < 10; i++) {
            startTime = System.currentTimeMillis();
            for (int j = 0; j < 20000; j++) {
                test.insert(1, j);
            }
            endTime = System.currentTimeMillis();
            test.clear();
            System.out.println(endTime - startTime);
            averageTime += (endTime - startTime);
        }
        System.out.println("Avarage Time inserting back: " + averageTime / 10);
    }

    private static void deleteTest(List<Integer> list) {

        long startTime;
        long endTime;
        long averageTime = 0;
        List<Integer> test = list;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 20000; i++) {
                test.insert(1, 0);
            }
            startTime= System.currentTimeMillis();
            for (int del=1; del<=1000; del++){
                test.delete(0);
            }
            endTime = System.currentTimeMillis();
            test.clear();
            averageTime+=(endTime-startTime);
            System.out.println(endTime-startTime);
        }
        System.out.println("Avarage Time deleting front: " + averageTime / 10);
        averageTime=0;

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 20000; i++) {
                test.insert(1, 0);
            }
            startTime= System.currentTimeMillis();
            for (int del=1; del<=1000; del++){
                test.delete((20000-del)%2);
            }
            endTime = System.currentTimeMillis();
            test.clear();
            averageTime+=(endTime-startTime);
            System.out.println(endTime-startTime);
        }
        System.out.println("Avarage Time deleting mid: " + averageTime / 10);

        averageTime=0;

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 20000; i++) {
                test.insert(1, 0);
            }
            startTime= System.currentTimeMillis();
            for (int del=1; del<=1000; del++){
                test.delete(20000-del);
            }
            endTime = System.currentTimeMillis();
            test.clear();
            averageTime+=(endTime-startTime);
            System.out.println(endTime-startTime);
        }
        System.out.println("Avarage Time deleting back: " + averageTime / 10);
    }


}
