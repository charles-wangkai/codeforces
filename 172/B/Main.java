import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int m = sc.nextInt();
    int r0 = sc.nextInt();

    System.out.println(solve(a, b, m, r0));

    sc.close();
  }

  static int solve(int a, int b, int m, int r0) {
    Map<Integer, Integer> valueToIndex = new HashMap<>();
    int value = r0;
    while (true) {
      if (valueToIndex.containsKey(value)) {
        return valueToIndex.size() - valueToIndex.get(value);
      }

      valueToIndex.put(value, valueToIndex.size());

      value = (a * value + b) % m;
    }
  }
}