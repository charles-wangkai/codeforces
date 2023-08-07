import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    List<Operation> operations = new ArrayList<>();
    OptionalInt positiveIndex = IntStream.range(0, a.length).filter(i -> a[i] > 0).findAny();
    if (positiveIndex.isPresent()) {
      for (int i = 0; i < 10; ++i) {
        operations.add(new Operation(positiveIndex.getAsInt(), positiveIndex.getAsInt()));
      }
      for (int i = positiveIndex.getAsInt() + 1; i < a.length; ++i) {
        operations.add(new Operation(i, i - 1));
      }
      for (int i = positiveIndex.getAsInt() - 1; i >= 0; --i) {
        operations.add(new Operation(i, i + 1));
      }
      for (int i = 1; i < a.length; ++i) {
        operations.add(new Operation(i, i - 1));
      }
    } else {
      for (int i = a.length - 2; i >= 0; --i) {
        operations.add(new Operation(i, i + 1));
      }
    }

    return String.format(
        "%d\n%s",
        operations.size(),
        operations.stream()
            .map(
                operation ->
                    String.format("%d %d", operation.toIndex() + 1, operation.fromIndex() + 1))
            .collect(Collectors.joining("\n")));
  }
}

record Operation(int toIndex, int fromIndex) {}
