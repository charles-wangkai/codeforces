import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int w = sc.nextInt();
    int h = sc.nextInt();

    System.out.println(solve(w, h));

    sc.close();
  }

  static long solve(int w, int h) {
    return (long) computeWayNum(w) * computeWayNum(h);
  }

  static int computeWayNum(int limit) {
    int result = 0;
    for (int i = 2; i <= limit; i += 2) {
      result += limit - i + 1;
    }

    return result;
  }
}