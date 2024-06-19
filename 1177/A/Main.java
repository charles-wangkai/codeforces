import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();

    System.out.println(solve(k));

    sc.close();
  }

  static int solve(int k) {
    StringBuilder sequence = new StringBuilder();
    for (int i = 1; sequence.length() < k; ++i) {
      sequence.append(i);
    }

    return sequence.charAt(k - 1) - '0';
  }
}