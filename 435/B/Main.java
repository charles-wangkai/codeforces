import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long a = sc.nextLong();
    int k = sc.nextInt();

    System.out.println(solve(a, k));

    sc.close();
  }

  static long solve(long a, int k) {
    int[] digits = String.valueOf(a).chars().map(c -> c - '0').toArray();
    for (int i = 0; i < digits.length; ++i) {
      int index =
          IntStream.range(i, Math.min(digits.length, i + k + 1))
              .boxed()
              .min(
                  Comparator.<Integer, Integer>comparing(j -> digits[j])
                      .reversed()
                      .thenComparing(j -> j))
              .get();

      for (int j = index; j > i; --j) {
        swap(digits, j, j - 1);
        --k;
      }
    }

    return Long.parseLong(
        Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining()));
  }

  static void swap(int[] digits, int index1, int index2) {
    int temp = digits[index1];
    digits[index1] = digits[index2];
    digits[index2] = temp;
  }
}