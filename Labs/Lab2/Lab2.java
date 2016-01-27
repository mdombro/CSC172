// Matthew Dombroski
// No partner for this lab
// Lab 2 - Combinatorics

public class Lab2 {
  public static void main(String[] args) {
    int c = combos(3, 4);
    System.out.println("Part 1:");
    System.out.printf("We can paint 3 houses with 4 different colors %d ways.\n", c);
    System.out.printf("An 8 to 10 letter/digit password has %d combinations.\n", combos(8,26+26+10)+combos(9,62)+combos(10,62));
    System.out.println("Part 2:");
    System.out.printf("There are %d orderings of 9 baseball players.\n", factorial(9));
    System.out.println("Part 3:");
    System.out.printf("The Pres, VP, Secretary, and Treasurer can be selected in %s ways.\n", orderedSelections(4, 200));
    System.out.printf("A sequence of 3 letters can be selected %s ways, a sequence of 5 letters can be selected %s ways.\n", orderedSelections(3,26), orderedSelections(5,26));
    System.out.println("Part 4:");
    System.out.printf("5 cards from a 52 card deck can give %d hands\n", unorderedSelections(52,5));
  }

  public static int combos(int objects, int options) {
    int combinations = 1;
    for (int i = 0; i < objects; i++) {
      combinations *= options;
    }
    return combinations;
  }

  public static int factorial(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n == 1 ? 1 : n * factorial(n - 1);
    }
  }

  public static int orderedSelections(int items, int objects) {
    int lowerBound = objects - items;
    int selections = 1;
    for (int i = objects; i > lowerBound; i--) {
      selections *= i;
    }
    return selections;
  }

  public static long unorderedSelections(long objects, long items) {
    if (items == objects || items == 0L){
        return 1L;  // choosing m items from n==m objects has only 1 selection
                    // choosing 0 items from n objects has only 1 selection
    }
    else {
      return unorderedSelections(objects-1L,items)+unorderedSelections(objects-1L, items-1L);
    }
  }
}