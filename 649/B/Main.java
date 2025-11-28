import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(n, m, k, a, b));

    sc.close();
  }

  static int solve(int n, int m, int k, int a, int b) {
    int fromEntrance = (a - 1) / (m * k);
    int fromFloor = (a - 1) % (m * k) / k;

    int toEntrance = (b - 1) / (m * k);
    int toFloor = (b - 1) % (m * k) / k;

    return (fromEntrance == toEntrance)
        ? computeTimeForFloor(fromFloor, toFloor)
        : (computeTimeForFloor(fromFloor, 0)
            + computeTimeForEntrance(n, fromEntrance, toEntrance)
            + computeTimeForFloor(0, toFloor));
  }

  static int computeTimeForFloor(int floor1, int floor2) {
    return Math.min(Math.abs(floor1 - floor2) * 5, 10 + Math.abs(floor1 - floor2));
  }

  static int computeTimeForEntrance(int n, int entrance1, int entrance2) {
    return Math.min(Math.abs(entrance1 - entrance2), n - Math.abs(entrance1 - entrance2)) * 15;
  }
}