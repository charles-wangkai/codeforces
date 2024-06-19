import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int r = sc.nextInt();
    int g = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(r, g, b));

    sc.close();
  }

  static int solve(int r, int g, int b) {
    int result = 30;
    int rest = r + g + b;
    int[] counts = {r, g, b};
    int index = 0;
    while (true) {
      int current = Math.min(2, counts[index]);
      counts[index] -= current;
      rest -= current;
      if (rest == 0) {
        break;
      }

      index = (index + 1) % counts.length;
      ++result;
    }

    return result;
  }
}