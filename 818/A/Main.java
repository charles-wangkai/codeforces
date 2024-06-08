import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long n = sc.nextLong();
    long k = sc.nextLong();

    System.out.println(solve(n, k));

    sc.close();
  }

  static String solve(long n, long k) {
    long winnerNum = n / 2 / (k + 1) * (k + 1);
    long diplomaNum = winnerNum / (k + 1);
    long certificateNum = winnerNum - diplomaNum;
    long noneNum = n - winnerNum;

    return String.format("%d %d %d", diplomaNum, certificateNum, noneNum);
  }
}