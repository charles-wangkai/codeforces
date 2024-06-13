import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] groups = new String[n];
    for (int i = 0; i < groups.length; ++i) {
      groups[i] = sc.next();
    }

    System.out.println(solve(groups));

    sc.close();
  }

  static int solve(String[] groups) {
    return IntStream.range(0, groups[0].length())
        .map(i -> (int) Arrays.stream(groups).filter(group -> group.charAt(i) == '1').count())
        .max()
        .getAsInt();
  }
}