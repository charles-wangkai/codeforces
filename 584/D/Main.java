// https://baike.baidu.com/item/%E5%BC%B1%E5%93%A5%E5%BE%B7%E5%B7%B4%E8%B5%AB%E7%8C%9C%E6%83%B3/8258248

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    List<Integer> ps = new ArrayList<>();
    if (n == 3 || n == 5) {
      ps.add(n);
    } else if (n == 7) {
      ps.add(3);
      ps.add(2);
      ps.add(2);
    } else {
      ps.add(3);

      for (int i = 3; ; i += 2) {
        if (isPrime(i) && isPrime(n - 3 - i)) {
          ps.add(i);
          ps.add(n - 3 - i);

          break;
        }
      }
    }

    return "%d\n%s"
        .formatted(ps.size(), ps.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  static boolean isPrime(int x) {
    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        return false;
      }
    }

    return true;
  }
}