import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    Map<Character, List<Integer>> letterToIndices = new HashMap<>();
    for (int i = 0; i < s.length(); ++i) {
      letterToIndices.putIfAbsent(s.charAt(i), new ArrayList<>());
      letterToIndices.get(s.charAt(i)).add(i);
    }

    return letterToIndices.values().stream()
        .mapToInt(
            indices ->
                IntStream.rangeClosed(0, indices.size())
                    .map(
                        i ->
                            ((i == indices.size()) ? s.length() : indices.get(i))
                                - ((i == 0) ? -1 : indices.get(i - 1)))
                    .max()
                    .getAsInt())
        .min()
        .getAsInt();
  }
}