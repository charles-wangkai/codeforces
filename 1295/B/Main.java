import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      sc.nextInt();
      int x = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, x));
    }

    sc.close();
  }

  static int solve(String s, int x) {
    SortedMap<Integer, Integer> balanceToCount = new TreeMap<>();
    int balance = 0;
    for (char c : s.toCharArray()) {
      balance += (c == '0') ? 1 : -1;
      balanceToCount.put(balance, balanceToCount.getOrDefault(balance, 0) + 1);
    }

    if (balance == 0) {
      return (x >= balanceToCount.firstKey() && x <= balanceToCount.lastKey()) ? -1 : 0;
    }

    int result = (x == 0) ? 1 : 0;
    if ((balance > 0 && x >= balanceToCount.firstKey())
        || (balance < 0 && x <= balanceToCount.lastKey())) {
      int offset;
      if (balance > 0 && x > balanceToCount.lastKey()) {
        offset = Math.ceilDiv(x - balanceToCount.lastKey(), balance) * balance;
      } else if (balance < 0 && x < balanceToCount.firstKey()) {
        offset = Math.ceilDiv(balanceToCount.firstKey() - x, -balance) * balance;
      } else {
        offset = 0;
      }

      while (x >= offset + balanceToCount.firstKey() && x <= offset + balanceToCount.lastKey()) {
        result += balanceToCount.getOrDefault(x - offset, 0);
        offset += balance;
      }
    }

    return result;
  }
}