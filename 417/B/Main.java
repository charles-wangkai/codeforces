import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] x = new int[n];
    int[] k = new int[n];
    for (int i = 0; i < n; ++i) {
      x[i] = sc.nextInt();
      k[i] = sc.nextInt();
    }

    System.out.println(solve(x, k) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int[] x, int[] k) {
    Map<Integer, Integer> participantToMaxX = new HashMap<>();
    for (int i = 0; i < x.length; ++i) {
      if (x[i] > participantToMaxX.getOrDefault(k[i], -1) + 1) {
        return false;
      }

      participantToMaxX.put(k[i], Math.max(participantToMaxX.getOrDefault(k[i], 0), x[i]));
    }

    return true;
  }
}