import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[2 * n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    int result = 0;
    for (int i = 0; i < a.length; i += 2) {
      int i_ = i;
      int index = IntStream.range(i + 1, a.length).filter(j -> a[j] == a[i_]).findAny().getAsInt();
      for (int j = index; j > i + 1; --j) {
        swap(a, j, j - 1);
        ++result;
      }
    }

    return result;
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }
}