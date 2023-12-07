import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    long[] result = new long[s.length()];
    char[] digits = s.toCharArray();
    int index = digits.length - 1;
    int oneCount = (digits[index] == '1') ? 1 : 0;
    long operationNum = 0;
    for (int i = 0; i < result.length; ++i) {
      if (operationNum != -1) {
        if (digits[index] == '0') {
          --index;

          if (index != -1 && digits[index] == '1') {
            ++oneCount;
          }
        } else {
          while (index != 0 && digits[index - 1] == '1') {
            ++oneCount;
            --index;
          }

          if (index == 0) {
            operationNum = -1;
          } else {
            operationNum += oneCount;
            --index;
            digits[index] = '1';
          }
        }
      }

      result[i] = operationNum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}