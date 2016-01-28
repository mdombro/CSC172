import java.util.*;
public class Lab3 {
  public static void main(String[] args) {
    System.out.printf("The letters of error can be arranged %d ways\n", nInkBins("Mississippi"));
  }

  public static int nInkBins(String word) { // n items over k groups
    int n = word.length();
    List<Character> bins = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (bins.contains(word.charAt(i)) == true) {
        continue;
      }
      else {
        bins.add(word.charAt(i));
        System.out.println(bins.size());
      }
    }
    int denom = 1;

    System.out.println(n+bins.size()-1 + " " + Integer.toString(bins.size()-1));
    return unorderedSelections(n+bins.size()-1, bins.size()-1);
    //return 3;
  }

  public static int unorderedSelections(int objects, int items) {
    if (items == objects || items == 0){
        return 1;   // choosing m items from n==m objects has only 1 selection
                    // choosing 0 items from n objects has only 1 selection
    }
    else {
      return unorderedSelections(objects-1,items)+unorderedSelections(objects-1, items-1);
    }
  }
}
