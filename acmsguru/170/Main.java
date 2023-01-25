import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String chain1 = sc.next();
    String chain2 = sc.next();

    System.out.println(solve(chain1, chain2));

    sc.close();
  }

  static int solve(String chain1, String chain2) {
    int[] plusIndices1 =
        IntStream.range(0, chain1.length()).filter(i -> chain1.charAt(i) == '+').toArray();
    int[] plusIndices2 =
        IntStream.range(0, chain2.length()).filter(i -> chain2.charAt(i) == '+').toArray();

    return (chain1.length() == chain2.length() && plusIndices1.length == plusIndices2.length)
        ? IntStream.range(0, plusIndices1.length)
            .map(i -> Math.abs(plusIndices1[i] - plusIndices2[i]))
            .sum()
        : -1;
  }
}
