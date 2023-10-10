import java.util.Scanner;

public class Main {
  static final Element[] CANDIDATES = {new Element(1, 4), new Element(1, 2), new Element(2, 5)};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    for (Element candidate : CANDIDATES) {
      int z = n - candidate.x() - candidate.y();
      if (z > candidate.y() && z % 3 != 0) {
        return String.format("YES\n%d %d %d", candidate.x(), candidate.y(), z);
      }
    }

    return "NO";
  }
}

record Element(int x, int y) {}
