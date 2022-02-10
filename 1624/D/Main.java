import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int ALPHABET_SIZE = 26;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static int solve(String s, int k) {
    int[] counts = new int[ALPHABET_SIZE];
    for (char c : s.toCharArray()) {
      ++counts[c - 'a'];
    }

    int avgPairNum = Arrays.stream(counts).map(c -> c / 2).sum() / k;
    int rest = s.length() - avgPairNum * 2 * k;

    return avgPairNum * 2 + ((rest >= k) ? 1 : 0);
  }
}