import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int k = a.length;

    PriorityQueue<Integer> aChosen = new PriorityQueue<>();
    int aChosenSum = 0;
    for (int ai : a) {
      aChosen.offer(ai);
      aChosenSum += ai;
    }

    PriorityQueue<Integer> bIgnored = new PriorityQueue<>(Comparator.reverseOrder());
    int bChosenSum = 0;
    for (int bi : b) {
      bIgnored.offer(bi);
    }

    while (true) {
      int chosenSize = k - k / 4;
      while (aChosen.size() > chosenSize) {
        aChosenSum -= aChosen.poll();
      }

      int ignoredSize = k - chosenSize;
      while (bIgnored.size() > ignoredSize) {
        bChosenSum += bIgnored.poll();
      }

      if (aChosenSum >= bChosenSum) {
        break;
      }

      aChosen.offer(100);
      aChosenSum += 100;
      bIgnored.offer(0);
      ++k;
    }

    return k - a.length;
  }
}
