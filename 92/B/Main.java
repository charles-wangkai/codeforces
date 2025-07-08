import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String x = sc.next();

    System.out.println(solve(x));

    sc.close();
  }

  static int solve(String x) {
    int firstOneIndex =
        IntStream.range(0, x.length()).filter(i -> x.charAt(i) == '1').min().getAsInt();
    int lastOneIndex =
        IntStream.range(0, x.length()).filter(i -> x.charAt(i) == '1').max().getAsInt();

    if (firstOneIndex == lastOneIndex) {
      return x.length() - 1 - lastOneIndex;
    }

    return x.length()
        + 1
        + (int)
            IntStream.rangeClosed(firstOneIndex, lastOneIndex)
                .filter(i -> x.charAt(i) == '0')
                .count();
  }
}