/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;
import java.util.*;
/**
 *
 * @author mdombros
 */
public class charMax {

    /**
     * @param args the command line arguments
     */

    // Generic findMax, with a function object.
    // Precondition: a.size( ) > 0.
    public static <AnyType> AnyType findMax( AnyType [ ] arr, Comparator<? super AnyType> cmp ) {
        int maxIndex = 0;
        for( int i = 1; i < arr.length; i++ )
            if( cmp.compare( arr[ i ], arr[ maxIndex ] ) > 0 )
                maxIndex = i;
        return arr[ maxIndex ];
    }

    static class CaseInsensitiveCompare implements Comparator<String> {
        public int compare( String lhs, String rhs ) { 
            return lhs.compareToIgnoreCase( rhs ); 
        }
    }
    
    static class CharacterCompare implements Comparator<Character> {
        public int compare( Character lhs, Character rhs) {
            return Character.toLowerCase(lhs) > Character.toLowerCase(rhs) ? lhs : rhs;
        }
    }


    static class TestProgram {
        public static void main( String [ ] args ) {
            String[] arr = { "ZEBRA", "alligator", "crocodile" };
            Character[] array = {'A','b','c','D','E','z'};
            System.out.println( findMax( arr, new CaseInsensitiveCompare( ) ) );
            System.out.println(findMax(array, new CharacterCompare()));
        }
    }
    
}
       




