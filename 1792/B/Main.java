import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a1 = sc.nextInt();
      int a2 = sc.nextInt();
      int a3 = sc.nextInt();
      int a4 = sc.nextInt();

      System.out.println(solve(a1, a2, a3, a4));
    }

    sc.close();
  }

  static int solve(int a1, int a2, int a3, int a4) {
    int result = a1;
    int aliceMood = a1;
    int bobMood = a1;

    if (aliceMood != 0 && bobMood != 0) {
      int commonCount = Math.min(a2, a3);
      a2 -= commonCount;
      a3 -= commonCount;
      result += 2 * commonCount;
    }

    int count2 = Math.min(a2, bobMood);
    a2 -= count2;
    aliceMood += count2;
    bobMood -= count2;
    result += count2;

    int count3 = Math.min(a3, aliceMood);
    a3 -= count3;
    aliceMood -= count3;
    bobMood += count3;
    result += count3;

    int count4 = Math.min(a4, Math.min(aliceMood, bobMood));
    a4 -= count4;
    result += count4;

    if (a2 != 0 || a3 != 0 || a4 != 0) {
      ++result;
    }

    return result;
  }
}
