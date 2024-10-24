import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int result = -1;
      int lower = 2;
      int upper = 999;
      while (lower <= upper) {
        int middle = (lower + upper) / 2;
        if (isMissing(sc, middle)) {
          result = middle;
          upper = middle - 1;
        } else {
          lower = middle + 1;
        }
      }

      System.out.println("! %d".formatted(result));
      System.out.flush();
    }

    sc.close();
  }

  static boolean isMissing(Scanner sc, int value) {
    System.out.println("? %d %d".formatted(value, value));
    System.out.flush();

    int size = sc.nextInt();

    return size != value * value;
  }
}