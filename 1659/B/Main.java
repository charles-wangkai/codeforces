import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
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

  static String solve(String s, int k) {
    int n = s.length();

    char[] bits = s.toCharArray();
    int[] f = new int[n];
    int rest = k;
    for (int i = 0; i < n; ++i) {
      if (k % 2 == 1) {
        flip(bits, i);
      }

      if (i == n - 1) {
        f[i] = rest;
        if (rest % 2 == 1) {
          flip(bits, i);
        }
      } else if (rest != 0 && bits[i] == '0') {
        f[i] = 1;
        flip(bits, i);
      }

      rest -= f[i];
    }

    return String.format(
        "%s\n%s",
        new String(bits),
        Arrays.stream(f).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  static void flip(char[] bits, int index) {
    bits[index] = (char) ('0' + '1' - bits[index]);
  }
}
