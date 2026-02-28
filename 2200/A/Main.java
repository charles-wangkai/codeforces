import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    return (int)
        IntStream.range(0, a.length).map(start -> computeWinner(a, start)).distinct().count();
  }

  static int computeWinner(int[] a, int start) {
    int[] rests = a.clone();
    int index = start;
    while (true) {
      if (rests[index] != 0) {
        --rests[index];

        if (Arrays.stream(rests).allMatch(rest -> rest == 0)) {
          return index;
        }
      }

      index = (index + 1) % rests.length;
    }
  }
}