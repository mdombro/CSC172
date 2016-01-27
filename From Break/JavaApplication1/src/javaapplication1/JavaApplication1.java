/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Random;

/**
 *
 * @author matthew
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+"!"+" = "+fact(i));
        }
        int[] b = array(10);
        System.out.println("Random array: ");
        array_print(b);
        array_sort(b);
        System.out.println("");
        array_print(b);
    }
    
    public static int fact(int num) {
        if (num == 1) {
            return 1;
        }
        return num*fact(num-1);
    }
    public static int[] array(int N) {
        Random randomGenerator = new Random();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = randomGenerator.nextInt(N+1);
        }
        return a;
    }
    public static void array_print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
    public static void array_sort(int[] array) {
        int l = array.length;
        for (int i = l-1; i >= 0; i--) {
            for (int h = 1; h <= i; h++) {
                if (array[h-1] > array[h]) {
                    int temp = array[h-1];
                    array[h-1] = array[h];
                    array[h]=temp;
                }
            }
        }
    }
}
