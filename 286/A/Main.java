import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    if (n % 4 >= 2) {
      return "-1";
    }

    int[] result = new int[n];
    int leftIndex = 0;
    int rightIndex = n - 1;
    int lowerValue = 1;
    int upperValue = n;
    while (leftIndex < rightIndex) {
      result[leftIndex] = lowerValue + 1;
      result[leftIndex + 1] = upperValue;
      result[rightIndex] = upperValue - 1;
      result[rightIndex - 1] = lowerValue;

      leftIndex += 2;
      rightIndex -= 2;
      lowerValue += 2;
      upperValue -= 2;
    }
    if (leftIndex == rightIndex) {
      result[leftIndex] = lowerValue;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}