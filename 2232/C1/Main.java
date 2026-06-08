import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int x = sc.nextInt();
      int s = sc.nextInt();
      String u = sc.next();

      System.out.println(solve(u, x, s));
    }

    sc.close();
  }

  static int solve(String u, int x, int s) {
    return IntStream.rangeClosed(0, u.length())
        .map(i -> computeSeatedNum(u, x, s, i))
        .max()
        .getAsInt();
  }

  static int computeSeatedNum(String u, int x, int s, int aToICount) {
    int result = 0;
    int freeNum = 0;
    for (char c : u.toCharArray()) {
      if (c == 'A') {
        if (aToICount == 0) {
          c = 'E';
        } else {
          --aToICount;
          c = 'I';
        }
      }

      if (c == 'I') {
        if (x != 0) {
          --x;
          freeNum += s - 1;
          ++result;
        }
      } else if (freeNum != 0) {
        --freeNum;
        ++result;
      }
    }

    return result;
  }
}