import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    return Integer.parseInt(
        Arrays.stream(s.split("0", -1))
            .mapToInt(String::length)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining()));
  }
}