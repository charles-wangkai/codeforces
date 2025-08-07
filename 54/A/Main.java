import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int C = sc.nextInt();
    int[] holidays = new int[C];
    for (int i = 0; i < holidays.length; ++i) {
      holidays[i] = sc.nextInt();
    }

    System.out.println(solve(N, K, holidays));

    sc.close();
  }

  static int solve(int N, int K, int[] holidays) {
    boolean[] presents = new boolean[N];
    for (int holiday : holidays) {
      presents[holiday - 1] = true;
    }

    int last = -1;
    for (int i = 0; i < presents.length; ++i) {
      if (!presents[i] && i - last == K) {
        presents[i] = true;
      }

      if (presents[i]) {
        last = i;
      }
    }

    return (int) IntStream.range(0, presents.length).filter(i -> presents[i]).count();
  }
}