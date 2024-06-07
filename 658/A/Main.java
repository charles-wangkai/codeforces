import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int c = sc.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }
    int[] t = new int[n];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }

    System.out.println(solve(p, t, c));

    sc.close();
  }

  static String solve(int[] p, int[] t, int c) {
    int point1 = computePoint(p, t, c, IntStream.range(0, p.length).toArray());
    int point2 =
        computePoint(p, t, c, IntStream.range(0, p.length).map(i -> p.length - 1 - i).toArray());

    if (point1 < point2) {
      return "Radewoosh";
    }
    if (point1 > point2) {
      return "Limak";
    }

    return "Tie";
  }

  static int computePoint(int[] p, int[] t, int c, int[] indices) {
    int result = 0;
    int time = 0;
    for (int index : indices) {
      time += t[index];
      result += Math.max(0, p[index] - c * time);
    }

    return result;
  }
}