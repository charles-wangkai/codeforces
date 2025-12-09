import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int l = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println("%.9f".formatted(solve(a, l)));
    }

    sc.close();
  }

  static double solve(int[] a, int l) {
    double result = 0;

    double leftPos = 0;
    int leftIndex = 0;
    int leftSpeed = 1;

    double rightPos = l;
    int rightIndex = a.length - 1;
    int rightSpeed = 1;

    while (leftIndex <= rightIndex) {
      double leftTime = (a[leftIndex] - leftPos) / leftSpeed;
      double rightTime = (rightPos - a[rightIndex]) / rightSpeed;
      if (leftTime < rightTime) {
        result += leftTime;

        leftPos = a[leftIndex];
        ++leftIndex;
        ++leftSpeed;

        rightPos -= rightSpeed * leftTime;
      } else {
        result += rightTime;

        rightPos = a[rightIndex];
        --rightIndex;
        ++rightSpeed;

        leftPos += leftSpeed * rightTime;
      }
    }

    result += (rightPos - leftPos) / (leftSpeed + rightSpeed);

    return result;
  }
}