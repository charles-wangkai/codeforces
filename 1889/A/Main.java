import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    if (s.chars().filter(c -> c == '0').count() * 2 != s.length()) {
      return "-1";
    }

    List<Integer> operations = new ArrayList<>();
    while (true) {
      int leftIndex = 0;
      int rightIndex = s.length() - 1;
      while (leftIndex < rightIndex && s.charAt(leftIndex) != s.charAt(rightIndex)) {
        ++leftIndex;
        --rightIndex;
      }
      if (leftIndex > rightIndex) {
        break;
      }

      if (s.charAt(leftIndex) == '0') {
        operations.add(rightIndex + 1);
        s = s.substring(0, rightIndex + 1) + "01" + s.substring(rightIndex + 1);
      } else {
        operations.add(leftIndex);
        s = s.substring(0, leftIndex) + "01" + s.substring(leftIndex);
      }
    }

    return String.format(
        "%d\n%s",
        operations.size(),
        operations.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}