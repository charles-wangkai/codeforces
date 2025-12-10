import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[k];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(n, m, a) ? "YA" : "TIDAK");
    }

    sc.close();
  }

  static boolean solve(int n, int m, int[] a) {
    int index = 0;
    Set<Integer> buffer = new HashSet<>();
    int value = a.length;
    while (value >= 1) {
      if (buffer.contains(value)) {
        buffer.remove(value);
        --value;
      } else if (buffer.size() == n * m - 3) {
        return false;
      } else {
        if (a[index] == value) {
          --value;
        } else {
          buffer.add(a[index]);
        }

        ++index;
      }
    }

    return true;
  }
}