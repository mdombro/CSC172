/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author matthew
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 10;
        Integer[] arry1 = new Integer[n];
        Integer[] arry2 = new Integer[n];
        Integer[] arry3 = new Integer[n];
        Double[] arry4 = new Double[n];
        
        rand_fill_double(arry4);
        print_arry(arry4);
        Arrays.sort(arry4);
        print_arry(arry4);
        
        rand_fill_int(arry1);
        System.arraycopy(arry1, 0, arry2, 0, n);
        print_arry(arry1);
        print_arry(arry2);
        
        Arrays.fill(arry3, 4);
        print_arry(arry3);
        
        boolean e = Arrays.equals(arry1, arry2);
        System.out.printf("arry1 and arry2 are%sequal\n", e ? " " : "not" );
        e = Arrays.equals(arry1, arry3);
        System.out.printf("arry1 and arry3 are %s equal\n", e ? " " : "not" );
        
        int ind1 = Arrays.binarySearch(arry4, 5.0);
        int ind2 = Arrays.binarySearch(arry4, 6.0);
        System.out.printf("Index of found variable is: %d\n", ind1);
        System.out.printf("Index of unfound variable is: %d\n", ind2);
        
        int ind3 = Arrays.binarySearch(arry2, arry2[0]);
        System.out.printf("Index from unsorted array: %d\n", ind3);
    }
    
    public static <T> void print_arry(T[] arry) {
        for (int o = 0; o < arry.length; o++) {
           System.out.print(arry[o] + " ");
        }
        System.out.println();
    }
    
    public static Double[] rand_fill_double(Double[] arry) {
        Random randomGen = new Random();
        for (int i = 0; i < arry.length; i++) {
            arry[i] = 100*randomGen.nextDouble();
        }
        arry[0] = 5.0; // known value
        return arry;
    }
    
    public static Integer[] rand_fill_int(Integer[] arry) {
        Random randomGen = new Random();
        for (int i = 0; i < arry.length; i++) {
            arry[i] = randomGen.nextInt(100);
        }
        return arry;
    }
}
