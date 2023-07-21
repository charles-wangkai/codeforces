import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String name = sc.next();
    System.out.println(solve(name) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(String name) {
    return IntStream.range(0, name.length())
            .filter(
                beginIndex ->
                    Stream.of("Danil", "Olya", "Slava", "Ann", "Nikita")
                        .anyMatch(friend -> name.startsWith(friend, beginIndex)))
            .count()
        == 1;
  }
}
