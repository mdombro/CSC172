import java.util.*;
public class Lab3 {
  public static void main(Stringp[] args) {

  }

  public static orderedItems(String[] word) { // n items over k groups
    int n = word.length;
    List bins = new ArrayListp<char>();
    for (int i = 0; i < n; i++) {
      if (word.getChar(i))
    }
    return unorderedSelections(n+k-1, k-1);
  }

  public static int factorial(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n == 1 ? 1 : n * factorial(n - 1);
    }
  }

  public static int unorderedSelections(int objects, int items) {
    if (items == objects || items == 0){
        return 1;  // choosing m items from n==m objects has only 1 selection
                    // choosing 0 items from n objects has only 1 selection
    }
    else {
      return unorderedSelections(objects-1,items)+unorderedSelections(objects-1, items-1);
    }
  }
}
