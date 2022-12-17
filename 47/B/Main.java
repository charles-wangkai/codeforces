import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] weightings = new String[3];
    for (int i = 0; i < weightings.length; ++i) {
      weightings[i] = sc.next();
    }

    System.out.println(solve(weightings));

    sc.close();
  }

  static String solve(String[] weightings) {
    return Stream.of("ABC", "ACB", "BCA", "BAC", "CAB", "CBA")
        .filter(
            rearrangement ->
                Arrays.stream(weightings)
                    .allMatch(
                        weighting ->
                            (weighting.charAt(1) == '<')
                                == (rearrangement.indexOf(weighting.charAt(0))
                                    < rearrangement.indexOf(weighting.charAt(2)))))
        .findAny()
        .orElse("Impossible");
  }
}
