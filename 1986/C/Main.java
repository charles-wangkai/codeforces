import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int m = sc.nextInt();
      String s = sc.next();
      int[] ind = new int[m];
      for (int i = 0; i < ind.length; ++i) {
        ind[i] = sc.nextInt();
      }
      String c = sc.next();

      System.out.println(solve(s, ind, c));
    }

    sc.close();
  }

  static String solve(String s, int[] ind, String c) {
    char[] letters = s.toCharArray();
    int[] indices = Arrays.stream(ind).map(i -> i - 1).distinct().sorted().toArray();
    Character[] sorted = c.chars().sorted().mapToObj(ci -> (char) ci).toArray(Character[]::new);
    for (int i = 0; i < indices.length; ++i) {
      letters[indices[i]] = sorted[i];
    }

    return new String(letters);
  }
}