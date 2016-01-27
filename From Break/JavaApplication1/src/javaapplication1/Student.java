/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author matthew
 */
public class Student {
    String name;
    int gradYear;
    
    public Student(String name, int gradYear){
        this.name = name;
        this.gradYear = gradYear;
        System.out.println("Student name is " + this.name);
    }
    
    public static void main(String[] args) {
        Student stu = new Student("Stu", 2015);
        stu.getName();
        stu.getgradYear();
        stu.setName("Matt");
        stu.setgradYear(2018);
        stu.getName();
        stu.getgradYear();
    }
    
    public String getName() {
        System.out.println("Name: "+this.name);
        return this.name;
    }
    
    public int getgradYear() {
        System.out.println("Graduation Year: "+this.gradYear);
        return this.gradYear;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setgradYear(int gradYear) {
        this.gradYear = gradYear;
    }
}


