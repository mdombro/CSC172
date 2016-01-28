import java.util.*;
public class Lab3 {
  public static void main(String[] args) {
    System.out.printf("The letters of Mississippi can be arranged %d ways\n", nInkBins("Mississippi"));
  }

  public static int nInkBins(String word) { // n items over k groups
    int n = word.length();
    List<Character> bins = new ArrayList<>();
    List<Integer> numOfBin = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (bins.contains(word.charAt(i)) == true) {   // Has letter been seen before?
        numOfBin.set(bins.indexOf(word.charAt(i)), numOfBin.get(bins.indexOf(word.charAt(i)))+1); // If so count it in correct group
      }
      else {  // add letter and instances to lists
        bins.add(word.charAt(i));
        numOfBin.add(1);
      }
    }
    int denom = 1;
    for (int k = 0; k < numOfBin.size(); k++) {
      denom *= factorial(numOfBin.get(k));
    }
    return factorial(n)/denom;
  }

  public static int factorial(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n == 1 ? 1 : n * factorial(n - 1);
    }
  }
}
