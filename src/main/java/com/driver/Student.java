package com.driver;

public class Student {

    private String name;
    private int age;
    private double averageScore;

    public Student(){

    }
    public Student(String name,int age,double averageScore){
        this.age=age;
        this.averageScore=averageScore;
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

}
