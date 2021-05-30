package com.test1;

import java.util.Comparator;

public class TestMain {
    public static void main(String[] args) {
        Car[] cars = new Car[] {
                new Car("jeep", 450000),
                new Car("vw", 100000),
                new Car("mazda", 150000),
                new Car("benz", 600000),
                new Car("honda", 200000),
                new Car("tesla", 300000)
        };

        printArray(cars);
        for (int i = 1; i <= cars.length - 1; i++) {
            for (int j = 1; j <= cars.length - i; j ++) {
                if (cars[j - 1].compareTo(cars[j]) > 0) {
                    Car temp = cars[j - 1];
                    cars[j - 1] = cars[j];
                    cars[j] = temp;
                }
            }
        }
        System.out.println();
        printArray(cars);

    }

    public static void printArray(Object[] objs) {
        for (Object obj : objs) {
            System.out.println(obj);
        }
    }

}

class Car implements Comparable{
    String name;
    int price;
    public Car(){
        super();
    }
    public Car(String name, int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString() {
        return name + ", " + price;
    }

    @Override
    public int compareTo(Object o) {
        return this.price - ((Car) o).price;
    }
}
