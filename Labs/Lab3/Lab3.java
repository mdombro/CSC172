import java.util.*;
public class Lab3 {
    public static void main(String[] args) {
        System.out.println("Part 1:");
        System.out.printf("The letters of error can be arranged %d ways\n", identicalOrdering("error"));
        System.out.printf("The letters of street can be arranged %d ways\n", identicalOrdering("street"));
        System.out.printf("The letters of allele can be arranged %d ways\n", identicalOrdering("allele"));
        System.out.printf("The letters of Mississippi can be arranged %d ways\n", identicalOrdering("Mississippi"));

        System.out.println("Part 2:");
        System.out.printf("Six apples to four children can be distributed %d ways\n", identicalBins(6,4));
        System.out.printf("Six apples to four children can be distributed %d ways\n", identicalBins(4,6));

        System.out.println("Part 3:");
        int[] t = {6,3};
        int[] t2 = {2,5,6};
        System.out.printf("Six apples and three pairs to five children can be distributed %d ways\n", distinguishableBins(t,5));
        System.out.printf("Two apples, five pears, and six bananas to three children can be distributed %d ways\n", distinguishableBins(t2, 3));
    }

    public static int identicalOrdering(String word) { // n items over k groups
        int n = word.length();
        List<Character> bins = new ArrayList<>();
        List<Integer> numOfBin = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (bins.contains(word.charAt(i))) {   // Has letter been seen before?
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

    public static int identicalBins(int n, int m) {  // n items across m bins
        return unorderedSelections(n+m-1, n);
    }

    public static int distinguishableBins(int[] k, int m) {
        int denom = 1;
        int n = 0;
        for (long l : k) {
            denom *= factorial(l);
            n += l;
        }
        return (int)(factorial((long)n+(long)m-1L)/(factorial((long)m-1L)*(long)denom));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n == 1 ? 1 : n * factorial(n - 1);
        }
    }

    public static long factorial(long n) {
        if (n == 0L) {
            return 1L;
        } else {
            return n == 1L ? 1L : n * factorial(n - 1L);
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
