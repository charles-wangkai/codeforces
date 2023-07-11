import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    int D = sc.nextInt();

    System.out.println(solve(A, B, C, D));

    sc.close();
  }

  static long solve(int A, int B, int C, int D) {
    long result = 0;

    boolean tooLow;
    boolean tooHigh;
    Point borderLeft = null;
    Point borderRight = null;
    long covered;
    if (B + (B - 1) <= C) {
      tooLow = true;
      tooHigh = false;
      covered = 0;
    } else {
      tooLow = false;

      if (A + (B - 1) > D + 1) {
        tooHigh = true;
        covered = (B - A + 1L) * (D - C + 1);
      } else {
        tooHigh = false;

        covered = 0;
        for (int z = C; z <= D; ++z) {
          int x = z + 1 - (B - 1);
          if (x <= B) {
            if (x >= A) {
              if (borderLeft == null && (x == A || z == C)) {
                borderLeft = new Point(x, z);
              }
              if (x == B || z == D) {
                borderRight = new Point(x, z);
              }
            }

            covered += B - Math.max(x, A) + 1;
          }
        }
      }
    }

    for (int y = B; y <= C; ++y) {
      if (tooLow) {
        if (B + y == C + 1) {
          tooLow = false;
          borderLeft = new Point(B, C);
          borderRight = new Point(B, C);
        }
      } else if (!tooHigh) {
        if (A + y > D + 1) {
          tooHigh = true;
        } else {
          if (borderLeft.x == A) {
            ++borderLeft.z;
          } else {
            --borderLeft.x;
          }

          if (borderRight.z == D) {
            --borderRight.x;
          } else {
            ++borderRight.z;
          }
        }
      }

      if (!tooLow && !tooHigh) {
        covered += borderRight.z - borderLeft.z + 1;
      }

      result += covered;
    }

    return result;
  }
}

class Point {
  int x;
  int z;

  Point(int x, int z) {
    this.x = x;
    this.z = z;
  }
}
