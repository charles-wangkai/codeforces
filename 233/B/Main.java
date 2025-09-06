import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long n = sc.nextLong();

    System.out.println(solve(n));

    sc.close();
  }

  static int solve(long n) {
    return IntStream.rangeClosed(1, 9 * 18 + 1)
        .flatMap(digitSum -> computeXs(n, digitSum).stream().mapToInt(Integer::intValue))
        .min()
        .orElse(-1);
  }

  static List<Integer> computeXs(long n, int digitSum) {
    List<Integer> result = new ArrayList<>();

    int a = 1;
    int b = digitSum;
    long c = -n;
    long det = b * b - 4 * a * c;
    if (det >= 0) {
      int sqrt = (int) Math.round(Math.sqrt(det));
      for (int x : new int[] {(-b - sqrt) / (2 * a), (-b + sqrt) / (2 * a)}) {
        if (x > 0
            && (long) x * x + (long) digitSum * x - n == 0
            && computeDigitSum(x) == digitSum) {
          result.add(x);
        }
      }
    }

    return result;
  }

  static int computeDigitSum(int x) {
    return String.valueOf(x).chars().map(c -> c - '0').sum();
  }
}