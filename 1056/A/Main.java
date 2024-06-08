import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] stops = new int[n][];
    for (int i = 0; i < stops.length; ++i) {
      int r = sc.nextInt();
      stops[i] = new int[r];
      for (int j = 0; j < stops[i].length; ++j) {
        stops[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(stops));

    sc.close();
  }

  static String solve(int[][] stops) {
    Set<Integer> result = Arrays.stream(stops[0]).boxed().collect(Collectors.toSet());
    for (int i = 1; i < stops.length; ++i) {
      result = Arrays.stream(stops[i]).filter(result::contains).boxed().collect(Collectors.toSet());
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}