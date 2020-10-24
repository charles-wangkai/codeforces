import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

  static String solve(int[] a) {
    int sum = Arrays.stream(a).sum();
    int[] negatives = Arrays.stream(a).filter(x -> x < 0).toArray();
    int[] positives = Arrays.stream(a).filter(x -> x > 0).toArray();
    int[] zeros = Arrays.stream(a).filter(x -> x == 0).toArray();

    if (sum < 0) {
      return String.format(
          "YES\n%s",
          IntStream.concat(
                  IntStream.concat(Arrays.stream(negatives), Arrays.stream(positives)),
                  Arrays.stream(zeros))
              .mapToObj(String::valueOf)
              .collect(Collectors.joining(" ")));
    } else if (sum > 0) {
      return String.format(
          "YES\n%s",
          IntStream.concat(
                  IntStream.concat(Arrays.stream(positives), Arrays.stream(negatives)),
                  Arrays.stream(zeros))
              .mapToObj(String::valueOf)
              .collect(Collectors.joining(" ")));
    } else {
      return "NO";
    }
  }
}
