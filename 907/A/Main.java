import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int V1 = sc.nextInt();
    int V2 = sc.nextInt();
    int V3 = sc.nextInt();
    int Vm = sc.nextInt();

    System.out.println(solve(V1, V2, V3, Vm));

    sc.close();
  }

  static String solve(int V1, int V2, int V3, int Vm) {
    for (int car1 = V1; car1 <= 2 * V1; ++car1) {
      for (int car2 = V2; car2 <= 2 * V2; ++car2) {
        for (int car3 = V3; car3 <= 2 * V3; ++car3) {
          if (car1 > car2
              && car2 > car3
              && canClimb(Vm, car1)
              && canClimb(Vm, car2)
              && canClimb(Vm, car3)
              && !isLike(Vm, car1)
              && !isLike(Vm, car2)
              && isLike(Vm, car3)) {
            return "%d\n%d\n%d".formatted(car1, car2, car3);
          }
        }
      }
    }

    return "-1";
  }

  static boolean canClimb(int a, int b) {
    return a <= b;
  }

  static boolean isLike(int a, int b) {
    return canClimb(a, b) && 2 * a >= b;
  }
}