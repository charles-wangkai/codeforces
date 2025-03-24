import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] names = new String[n];
    String[][] phones = new String[n][];
    for (int i = 0; i < n; ++i) {
      int s = sc.nextInt();
      names[i] = sc.next();
      phones[i] = new String[s];
      for (int j = 0; j < phones[i].length; ++j) {
        phones[i][j] = sc.next();
      }
    }

    System.out.println(solve(names, phones));

    sc.close();
  }

  static String solve(String[] names, String[][] phones) {
    int n = names.length;

    int[] taxiCounts = new int[n];
    int[] pizzCounts = new int[n];
    int[] girlCounts = new int[n];
    for (int i = 0; i < n; ++i) {
      for (String phone : phones[i]) {
        if (isTaxi(phone)) {
          ++taxiCounts[i];
        } else if (isPizza(phone)) {
          ++pizzCounts[i];
        } else {
          ++girlCounts[i];
        }
      }
    }

    return "If you want to call a taxi, you should call: %s.\nIf you want to order a pizza, you should call: %s.\nIf you want to go to a cafe with a wonderful girl, you should call: %s."
        .formatted(
            findNames(names, taxiCounts),
            findNames(names, pizzCounts),
            findNames(names, girlCounts));
  }

  static String findNames(String[] names, int[] counts) {
    int maxCount = Arrays.stream(counts).max().getAsInt();

    return IntStream.range(0, counts.length)
        .filter(i -> counts[i] == maxCount)
        .mapToObj(i -> names[i])
        .collect(Collectors.joining(", "));
  }

  static boolean isTaxi(String phone) {
    int[] digits = buildDigits(phone);

    return Arrays.stream(digits).distinct().count() == 1;
  }

  static boolean isPizza(String phone) {
    int[] digits = buildDigits(phone);

    return IntStream.range(0, digits.length - 1).allMatch(i -> digits[i] > digits[i + 1]);
  }

  static int[] buildDigits(String phone) {
    return phone.chars().filter(c -> c != '-').map(c -> c - '0').toArray();
  }
}