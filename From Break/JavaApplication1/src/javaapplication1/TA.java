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
public class TA extends Student {
    int hourlyRate;
    
    public TA(String name, int gradYear, int hourlyRate) {
        super(name, gradYear);
        this.hourlyRate = hourlyRate;
    }
    
    public static void main(String[] args) {
        TA stu = new TA("Stu", 2015, 10);
        stu.getName();
        stu.getgradYear();
        stu.gethourlyRate();
        stu.setName("Matt");
        stu.setgradYear(2018);
        stu.sethourlyRate(15);
        stu.getName();
        stu.getgradYear();
        stu.gethourlyRate();
    }
    
    public int gethourlyRate() {
        System.out.println(this.hourlyRate);
        return this.hourlyRate;
    }
    
    public void sethourlyRate(int rate) {
        this.hourlyRate = rate;
    }
}
