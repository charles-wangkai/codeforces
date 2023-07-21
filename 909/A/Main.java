import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String firstName = sc.next();
    String lastName = sc.next();
    System.out.println(solve(firstName, lastName));

    sc.close();
  }

  static String solve(String firstName, String lastName) {
    return IntStream.rangeClosed(1, firstName.length())
        .mapToObj(endIndex -> firstName.substring(0, endIndex) + lastName.charAt(0))
        .min(Comparator.naturalOrder())
        .get();
  }
}
