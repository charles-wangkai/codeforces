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
    int result = 1;
    int parentNum = 1;
    int nextParentNum = 1;
    int parentIndex = 0;
    for (int i = 2; i < a.length; ++i) {
      if (a[i] > a[i - 1]) {
        ++nextParentNum;
      } else if (parentIndex != parentNum - 1) {
        ++nextParentNum;
        ++parentIndex;
      } else {
        parentNum = nextParentNum;
        nextParentNum = 1;
        parentIndex = 0;
        ++result;
      }
    }

    return result;
  }
}