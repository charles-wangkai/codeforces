import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int rating = sc.nextInt();

      System.out.println(solve(rating));
    }

    sc.close();
  }

  static String solve(int rating) {
    int X;
    if (rating >= 1900) {
      X = 1;
    } else if (rating >= 1600) {
      X = 2;
    } else if (rating >= 1400) {
      X = 3;
    } else {
      X = 4;
    }

    return String.format("Division %d", X);
  }
}