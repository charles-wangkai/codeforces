import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    if (N == 2) {
      return """
        3 4
        5 2 3""";
    }

    @SuppressWarnings("unchecked")
    List<Integer>[] turns = new List[N + 1];
    for (int i = 0; i < turns.length; ++i) {
      turns[i] = new ArrayList<>();
    }
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        if (r + c >= N + 1) {
          turns[0].add(r * N + c + 1);
        } else if (r + c != 0) {
          turns[N - (r + c) + 1].add(r * N + c + 1);
        }
      }
    }

    int[] moveNums = new int[turns.length];
    moveNums[0] = N;
    moveNums[1] = N + (N % 2 + 1);
    for (int i = 2; i < moveNums.length; ++i) {
      moveNums[i] = moveNums[i - 1] + 2;
    }

    return IntStream.range(0, turns.length)
        .mapToObj(
            i ->
                String.format(
                    "%d %s",
                    moveNums[i],
                    turns[i].stream().map(String::valueOf).collect(Collectors.joining(" "))))
        .collect(Collectors.joining("\n"));
  }
}
