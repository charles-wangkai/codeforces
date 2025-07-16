import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    System.out.println(solve(a, b, c));

    sc.close();
  }

  static String solve(int a, int b, int c) {
    double solution1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    double solution2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

    return "%.9f\n%.9f".formatted(Math.max(solution1, solution2), Math.min(solution1, solution2));
  }
}