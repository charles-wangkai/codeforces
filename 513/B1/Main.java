import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long m = sc.nextLong();

    System.out.println(solve(n, m));

    sc.close();
  }

  static String solve(int n, long m) {
    int[] result = new int[n];
    int leftIndex = 0;
    int rightIndex = result.length - 1;
    int value = 1;
    while (leftIndex <= rightIndex) {
      if (leftIndex == rightIndex || (((m - 1) >> (rightIndex - leftIndex - 1)) & 1) == 0) {
        result[leftIndex] = value;
        ++leftIndex;
      } else {
        result[rightIndex] = value;
        --rightIndex;
      }

      ++value;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}