import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    sc.nextLine();
    String[] hints = new String[m];
    for (int i = 0; i < hints.length; ++i) {
      hints[i] = sc.nextLine();
    }

    System.out.println(solve(n, hints));

    sc.close();
  }

  static int solve(int n, String[] hints) {
    int min = 1;
    int max = n;
    for (String hint : hints) {
      String[] fields = hint.split(" ");
      if (fields[2].equals("left")) {
        max = Math.min(max, Integer.parseInt(fields[4]) - 1);
      } else {
        min = Math.max(min, Integer.parseInt(fields[4]) + 1);
      }
    }

    return (min <= max) ? (max - min + 1) : -1;
  }
}