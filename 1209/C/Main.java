import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String d = sc.next();

      System.out.println(solve(d));
    }

    sc.close();
  }

  static String solve(String d) {
    for (char middle = '0'; middle <= '9'; ++middle) {
      List<Integer> lowerIndices = new ArrayList<>();
      List<Integer> upperIndices = new ArrayList<>();
      List<Integer> middleIndices = new ArrayList<>();
      for (int i = 0; i < d.length(); ++i) {
        if (d.charAt(i) < middle) {
          lowerIndices.add(i);
        } else if (d.charAt(i) > middle) {
          upperIndices.add(i);
        } else {
          middleIndices.add(i);
        }
      }

      if (IntStream.range(0, lowerIndices.size() - 1)
              .allMatch(i -> d.charAt(lowerIndices.get(i)) <= d.charAt(lowerIndices.get(i + 1)))
          && IntStream.range(0, upperIndices.size() - 1)
              .allMatch(i -> d.charAt(upperIndices.get(i)) <= d.charAt(upperIndices.get(i + 1)))
          && !(!lowerIndices.isEmpty()
              && !upperIndices.isEmpty()
              && middleIndices.stream()
                  .anyMatch(
                      middleIndex ->
                          middleIndex > upperIndices.getFirst()
                              && middleIndex < lowerIndices.getLast()))) {
        char[] result = new char[d.length()];
        for (int lowerIndex : lowerIndices) {
          result[lowerIndex] = '1';
        }
        for (int upperIndex : upperIndices) {
          result[upperIndex] = '2';
        }
        for (int middleIndex : middleIndices) {
          result[middleIndex] =
              (lowerIndices.isEmpty() || middleIndex > lowerIndices.getLast()) ? '1' : '2';
        }

        return String.valueOf(result);
      }
    }

    return "-";
  }
}