import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String colors = sc.next();

    System.out.println(solve(colors));

    sc.close();
  }

  static int solve(String colors) {
    List<Segment> segments = new ArrayList<>();
    int count = -1;
    for (int i = 0; i <= colors.length(); ++i) {
      if (i != colors.length() && i != 0 && colors.charAt(i) == colors.charAt(i - 1)) {
        ++count;
      } else {
        if (i != 0) {
          segments.add(new Segment(colors.charAt(i - 1), count));
        }

        count = 1;
      }
    }

    return (segments.size() % 2 == 1
            && segments.get(segments.size() / 2).length() >= 2
            && IntStream.range(0, segments.size() / 2)
                .allMatch(
                    i ->
                        segments.get(i).color() == segments.get(segments.size() - 1 - i).color()
                            && segments.get(i).length()
                                    + segments.get(segments.size() - 1 - i).length()
                                >= 3))
        ? (segments.get(segments.size() / 2).length() + 1)
        : 0;
  }
}

record Segment(char color, int length) {}
