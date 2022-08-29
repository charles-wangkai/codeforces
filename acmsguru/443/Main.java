import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(int a, int b) {
    return (computeKeyNumber(a) > computeKeyNumber(b)) ? "a" : "b";
  }

  static int computeKeyNumber(int x) {
    List<Integer> primeFactors = new ArrayList<>();
    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        primeFactors.add(i);
        while (x % i == 0) {
          x /= i;
        }
      }
    }
    if (x != 1) {
      primeFactors.add(x);
    }

    return 2 * primeFactors.get(primeFactors.size() - 1)
        - primeFactors.stream().mapToInt(a -> a).sum();
  }
}