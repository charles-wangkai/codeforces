import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int A) {
    return "%d 2\n1 2".formatted(2 * A - 1);
  }
}