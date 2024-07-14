import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b, int[] c) {

    return Stream.of(
            new Element(a, 0, b, 1, c, 2),
            new Element(a, 0, c, 2, b, 1),
            new Element(b, 1, a, 0, c, 2),
            new Element(b, 1, c, 2, a, 0),
            new Element(c, 2, a, 0, b, 1),
            new Element(c, 2, b, 1, a, 0))
        .map(Main::findDivisions)
        .filter(Objects::nonNull)
        .findAny()
        .orElse("-1");
  }

  static String findDivisions(Element element) {
    int n = element.leftValues.length;

    long total = Arrays.stream(element.leftValues).asLongStream().sum();
    long targetSum = (total + 2) / 3;

    long leftSum = 0;
    long middleSum = 0;
    long rightSum = total;
    int endIndex = -1;
    for (int beginIndex = 0; beginIndex < n; ++beginIndex) {
      while (middleSum < targetSum && endIndex != n - 1) {
        ++endIndex;
        middleSum += element.middleValues[endIndex];
        rightSum -= element.rightValues[endIndex];
      }

      if (leftSum >= targetSum && middleSum >= targetSum && rightSum >= targetSum) {
        int[] divisions = new int[6];
        divisions[element.leftIndex * 2] = 1;
        divisions[element.leftIndex * 2 + 1] = beginIndex;
        divisions[element.middleIndex * 2] = beginIndex + 1;
        divisions[element.middleIndex * 2 + 1] = endIndex + 1;
        divisions[element.rightIndex * 2] = endIndex + 2;
        divisions[element.rightIndex * 2 + 1] = n;

        return Arrays.stream(divisions).mapToObj(String::valueOf).collect(Collectors.joining(" "));
      }

      middleSum -= element.middleValues[beginIndex];
      leftSum += element.leftValues[beginIndex];
    }

    return null;
  }
}

class Element {
  int[] leftValues;
  int leftIndex;
  int[] middleValues;
  int middleIndex;
  int[] rightValues;
  int rightIndex;

  Element(
      int[] leftValues,
      int leftIndex,
      int[] middleValues,
      int middleIndex,
      int[] rightValues,
      int rightIndex) {
    this.leftValues = leftValues;
    this.leftIndex = leftIndex;
    this.middleValues = middleValues;
    this.middleIndex = middleIndex;
    this.rightValues = rightValues;
    this.rightIndex = rightIndex;
  }
}
