import java.math.BigInteger;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String n = sc.next();

    System.out.println(solve(n));

    sc.close();
  }

  static BigInteger solve(String n) {
    int largerLeftLength = Integer.MAX_VALUE;
    int smallerLeftLength = Integer.MIN_VALUE;
    for (int leftLength = 1; leftLength < n.length(); ++leftLength) {
      int rightLength = n.length() - leftLength;
      if (n.charAt(n.length() - rightLength) != '0') {
        if (leftLength >= rightLength) {
          largerLeftLength = Math.min(largerLeftLength, leftLength);
        } else {
          smallerLeftLength = Math.max(smallerLeftLength, leftLength);
        }
      }
    }

    return IntStream.of(largerLeftLength, smallerLeftLength)
        .filter(leftLength -> leftLength != Integer.MAX_VALUE && leftLength != Integer.MIN_VALUE)
        .mapToObj(
            leftLength ->
                new BigInteger(n.substring(0, leftLength))
                    .add(new BigInteger(n.substring(leftLength))))
        .min(Comparator.naturalOrder())
        .get();
  }
}