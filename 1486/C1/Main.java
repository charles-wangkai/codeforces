import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(String.format("? 1 %d", n));
    System.out.flush();
    int secondIndex = sc.nextInt();

    boolean leftOrRight;
    if (secondIndex == 1) {
      leftOrRight = false;
    } else if (secondIndex == n) {
      leftOrRight = true;
    } else {
      System.out.println(String.format("? 1 %d", secondIndex));
      System.out.flush();
      leftOrRight = sc.nextInt() == secondIndex;
    }

    int distance = -1;
    int lower = 1;
    int upper = leftOrRight ? secondIndex : (n - secondIndex);
    while (lower <= upper) {
      int middle = (lower + upper) / 2;

      System.out.println(
          String.format(
              "? %d %d",
              leftOrRight ? (secondIndex - middle) : secondIndex,
              leftOrRight ? secondIndex : (secondIndex + middle)));
      System.out.flush();
      if (sc.nextInt() == secondIndex) {
        distance = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    System.out.println(String.format("! %d", secondIndex + (leftOrRight ? -1 : 1) * distance));
    System.out.flush();

    sc.close();
  }
}
