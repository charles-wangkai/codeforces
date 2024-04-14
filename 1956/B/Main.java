import java.util.Arrays;
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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int n = a.length;

    int[] counts = new int[n];
    for (int ai : a) {
      ++counts[ai - 1];
    }

    return computeNum(counts, 2)
        + ((computeNum(counts, 2) > computeNum(counts, 0)) ? computeNum(counts, 1) : 0);
  }

  static int computeNum(int[] counts, int count) {
    return (int) Arrays.stream(counts).filter(c -> c == count).count();
  }
 }