import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int BIT_NUM = 60;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(long n) {
    List<Long> sequence = new ArrayList<>();
    sequence.add(n);

    int[] oneBits = IntStream.range(0, BIT_NUM).filter(i -> ((n >> i) & 1) == 1).toArray();
    if (oneBits.length >= 2) {
      for (int oneBit : oneBits) {
        sequence.add(n ^ (1L << oneBit));
      }
    }
    Collections.reverse(sequence);

    return "%d\n%s"
        .formatted(
            sequence.size(),
            sequence.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}