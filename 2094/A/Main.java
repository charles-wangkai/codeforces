import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    sc.nextLine();
    for (int tc = 0; tc < t; ++tc) {
      String name = sc.nextLine();

      System.out.println(solve(name));
    }

    sc.close();
  }

  static String solve(String name) {
    return Arrays.stream(name.split(" "))
        .map(part -> part.substring(0, 1))
        .collect(Collectors.joining());
  }
}