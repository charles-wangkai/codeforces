import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    int[] leftNums = new int[s.length()];
    Set<Character> leftLetters = new HashSet<>();
    for (int i = 0; i < leftNums.length; ++i) {
      leftLetters.add(s.charAt(i));
      leftNums[i] = leftLetters.size();
    }

    int[] rightNums = new int[s.length()];
    Set<Character> rightLetters = new HashSet<>();
    for (int i = rightNums.length - 1; i >= 0; --i) {
      rightLetters.add(s.charAt(i));
      rightNums[i] = rightLetters.size();
    }

    return IntStream.range(0, s.length() - 1)
        .map(i -> leftNums[i] + rightNums[i + 1])
        .max()
        .getAsInt();
  }
}
