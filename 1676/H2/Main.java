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

  static long solve(int[] a) {
    long result = 0;
    int[] binaryIndexedTree = new int[Integer.highestOneBit(a.length) * 2 + 1];
    for (int ai : a) {
      result += computeSum(binaryIndexedTree, a.length) - computeSum(binaryIndexedTree, ai - 1);
      add(binaryIndexedTree, ai, 1);
    }

    return result;
  }

  static void add(int[] binaryIndexedTree, int i, int x) {
    while (i < binaryIndexedTree.length) {
      binaryIndexedTree[i] += x;
      i += i & -i;
    }
  }

  static int computeSum(int[] binaryIndexedTree, int i) {
    int result = 0;
    while (i != 0) {
      result += binaryIndexedTree[i];
      i -= i & -i;
    }

    return result;
  }
}