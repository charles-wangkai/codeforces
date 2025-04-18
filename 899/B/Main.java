import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  static final int[] MONTH_BASE_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int[] a) {
    int[] days =
        Stream.of(
                buildMonthDays(false),
                buildMonthDays(false),
                buildMonthDays(false),
                buildMonthDays(true),
                buildMonthDays(false),
                buildMonthDays(false),
                buildMonthDays(false))
            .flatMapToInt(Arrays::stream)
            .toArray();

    return IntStream.rangeClosed(0, days.length - a.length)
        .anyMatch(
            beginIndex -> IntStream.range(0, a.length).allMatch(i -> a[i] == days[beginIndex + i]));
  }

  static int[] buildMonthDays(boolean leapYear) {
    return IntStream.range(0, MONTH_BASE_DAYS.length)
        .map(i -> MONTH_BASE_DAYS[i] + ((leapYear && i == 1) ? 1 : 0))
        .toArray();
  }
}