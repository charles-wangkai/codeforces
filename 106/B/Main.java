import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] speed = new int[n];
    int[] ram = new int[n];
    int[] hdd = new int[n];
    int[] cost = new int[n];
    for (int i = 0; i < n; ++i) {
      speed[i] = sc.nextInt();
      ram[i] = sc.nextInt();
      hdd[i] = sc.nextInt();
      cost[i] = sc.nextInt();
    }

    System.out.println(solve(speed, ram, hdd, cost));

    sc.close();
  }

  static int solve(int[] speed, int[] ram, int[] hdd, int[] cost) {
    return IntStream.range(0, speed.length)
            .filter(
                i ->
                    !IntStream.range(0, speed.length)
                        .anyMatch(j -> speed[j] > speed[i] && ram[j] > ram[i] && hdd[j] > hdd[i]))
            .boxed()
            .min(Comparator.comparing(i -> cost[i]))
            .get()
        + 1;
  }
}