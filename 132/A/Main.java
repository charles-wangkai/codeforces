import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String text = sc.nextLine();

    System.out.println(solve(text));

    sc.close();
  }

  static String solve(String text) {
    List<Integer> result = new ArrayList<>();
    int prev = 0;
    for (char c : text.toCharArray()) {
      int curr =
          Integer.parseInt(
              new StringBuilder("%8s".formatted(Integer.toBinaryString(c)).replace(' ', '0'))
                  .reverse()
                  .toString(),
              2);
      result.add(Math.floorMod(prev - curr, 256));

      prev = curr;
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}