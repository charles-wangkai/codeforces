import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String road = sc.next();

    System.out.println(solve(road));

    sc.close();
  }

  static String solve(String road) {
    int leftIndex =
        IntStream.range(0, road.length()).filter(i -> road.charAt(i) != '.').findFirst().getAsInt();
    int rightIndex =
        IntStream.range(0, road.length()).filter(i -> road.charAt(i) != '.').max().getAsInt();

    int s;
    int t;
    if (road.charAt(rightIndex) == 'R') {
      s = leftIndex + 1;
      t = rightIndex + 2;
    } else if (road.charAt(leftIndex) == 'L') {
      s = rightIndex + 1;
      t = leftIndex;
    } else {
      s = leftIndex + 1;
      t = IntStream.range(0, road.length()).filter(i -> road.charAt(i) == 'R').max().getAsInt() + 1;
    }

    return String.format("%d %d", s, t);
  }
}
