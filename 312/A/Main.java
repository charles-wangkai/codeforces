import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] sentences = new String[n];
    sc.nextLine();
    for (int i = 0; i < sentences.length; ++i) {
      sentences[i] = sc.nextLine();
    }

    System.out.println(solve(sentences));

    sc.close();
  }

  static String solve(String[] sentences) {
    return Arrays.stream(sentences)
        .map(
            sentence -> {
              boolean endMatched = sentence.endsWith("lala.");
              boolean beginMatched = sentence.startsWith("miao.");

              if (endMatched && !beginMatched) {
                return "Freda's";
              }
              if (beginMatched && !endMatched) {
                return "Rainbow's";
              }

              return "OMG>.< I don't know!";
            })
        .collect(Collectors.joining("\n"));
  }
}