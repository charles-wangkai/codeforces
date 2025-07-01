import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] a = new int[n][6];
    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[][] a) {
    Set<Integer> values = new HashSet<>();
    permute(values, a, 0);

    int result = 0;
    while (values.contains(result + 1)) {
      ++result;
    }

    return result;
  }

  static void permute(Set<Integer> values, int[][] a, int index) {
    if (index == a.length) {
      extend(values, a, 0, 0);

      return;
    }

    for (int i = index; i < a.length; ++i) {
      swap(a, i, index);
      permute(values, a, index + 1);
      swap(a, i, index);
    }
  }

  static void swap(int[][] a, int index1, int index2) {
    int[] temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }

  static void extend(Set<Integer> values, int[][] a, int value, int index) {
    if (index != a.length) {
      for (int digit : a[index]) {
        int nextValue = value * 10 + digit;
        values.add(nextValue);

        extend(values, a, nextValue, index + 1);
      }
    }
  }
}