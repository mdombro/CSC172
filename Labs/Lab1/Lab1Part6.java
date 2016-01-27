// Matthew Dombroski
// No partner for this lab

import java.util.*;

public class Lab1Part6 {

  public static void main( String [ ] args ) {
      String[] arr = { "ZEBRA", "alligator", "crocodile" };
      Character[] array = {'A','b','c','D','E','z'};
      System.out.println( findMax( arr, new CaseInsensitiveCompare( ) ) );
      System.out.println(findMax(array, new CharacterCompare()));
  }

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
}
