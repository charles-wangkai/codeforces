import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      solve(sc, n);
    }

    sc.close();
  }

  static void solve(Scanner sc, int n) {
    int beginPos = 1;
    int endPos = n;
    while (beginPos < endPos) {
      int middlePos = (beginPos + endPos) / 2;

      int[] response = query(sc, beginPos, middlePos);
      int beginPos_ = beginPos;
      if (Arrays.stream(response).filter(x -> x >= beginPos_ && x <= middlePos).count() % 2 == 1) {
        endPos = middlePos;
      } else {
        beginPos = middlePos + 1;
      }
    }

    System.out.println("! %d".formatted(beginPos));
    System.out.flush();
  }

  static int[] query(Scanner sc, int l, int r) {
    System.out.println("? %d %d".formatted(l, r));
    System.out.flush();

    int[] result = new int[r - l + 1];
    for (int i = 0; i < result.length; ++i) {
      result[i] = sc.nextInt();
    }

    return result;
  }
}