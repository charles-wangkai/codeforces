import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    return IntStream.range(0, 1 << s.length())
        .mapToObj(
            code ->
                IntStream.range(0, s.length())
                    .filter(i -> (code & (1 << i)) != 0)
                    .mapToObj(s::charAt)
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString())
        .filter(substr -> new StringBuilder(substr).reverse().toString().equals(substr))
        .max(Comparator.naturalOrder())
        .get();
  }
}
