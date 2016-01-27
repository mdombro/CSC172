// Matthew Dombroski
// No partner for this lab

public class Lab1Parts1to5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] intArry = {1, 2, 3, 4, 5 };
        Double[] doubArry = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H','E','L', 'L', 'O' };
        String[] strArray = {"once", "upon", "a", "time" };

        // printarray(intArry);
        // printarray(doubArry);
        // printarray(charArray);
        // printarray(strArray);

        System.out.println("max Integer is : " + getMax(intArry));
        System.out.println("max Double is : " + getMax(doubArry));
        System.out.println("max Character is : " + getMax(charArray));
        System.out.println("max String is : " + getMax(strArray));
    }

    // Array of Objects
    // public static void printarray(Object[] array) {
    //     for (int o = 0; o < array.length; o++) {
    //         System.out.println(array[o]);
    //     }
    // }

    // Method Overloading
  //  public static void printarray(Integer[] thing) {
  //      for (int i = 0; i < thing.length; i++) {
  //          System.out.println(thing[i]);
  //      }
  //  }
  //  public static void printarray(Double[] thing) {
  //      for (int i = 0; i < thing.length; i++) {
  //          System.out.println(thing[i]);
  //      }
  //  }
  //  public static void printarray(Character[] thing) {
  //      for (int i = 0; i < thing.length; i++) {
  //          System.out.println(thing[i]);
  //      }
  //  }
  //  public static void printarray(String[] thing) {
  //      for (int i = 0; i < thing.length; i++) {
  //          System.out.println(thing[i]);
  //      }
  //  }


    // Generic method
  //  public static <T> void printarray(T[] array) {
  //      for (int o = 0; o < array.length; o++) {
  //          System.out.println(array[o]);
  //      }
  //  }

    // Comparable Sort
  //  public static Comparable getMax(Comparable[] array) {
  //      Comparable max = array[0];
  //      for (int i = 0; i < array.length; i++) {
  //          if (array[i].compareTo(max) > 0) {
  //              max = array[i];
  //          }
  //      }
  //      return max;
  //  }

    // Generic getMax()
    public static <T extends Comparable> T getMax(T[] array) {
       T max = array[0];
       for (int i = 0; i < array.length; i++) {
           if (array[i].compareTo(max) > 0) {
               max = array[i];
           }
        }
        return max;
    }

}
