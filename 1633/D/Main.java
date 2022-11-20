import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final int LIMIT = 1000;
  static int[] operationNums;

  public static void main(String[] args) {
    buildOperationNums();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(b, c, k));
    }

    sc.close();
  }

  static void buildOperationNums() {
    operationNums = new int[LIMIT + 1];
    Arrays.fill(operationNums, Integer.MAX_VALUE);
    operationNums[1] = 0;
    for (int i = 1; i < operationNums.length; ++i) {
      for (int j = 1; j <= i; ++j) {
        int next = i + i / j;
        if (next < operationNums.length) {
          operationNums[next] = Math.min(operationNums[next], operationNums[i] + 1);
        }
      }
    }
  }

  static int solve(int[] b, int[] c, int k) {
    Map<Integer, Integer> operationNumToMaxCoinNum = Map.of(0, 0);
    for (int i = 0; i < b.length; ++i) {
      Map<Integer, Integer> nextOperationNumToMaxCoinNum = new HashMap<>(operationNumToMaxCoinNum);
      for (int operationNum : operationNumToMaxCoinNum.keySet()) {
        int nextOperationNum = operationNum + operationNums[b[i]];
        if (nextOperationNum <= k) {
          nextOperationNumToMaxCoinNum.put(
              nextOperationNum,
              Math.max(
                  nextOperationNumToMaxCoinNum.getOrDefault(nextOperationNum, 0),
                  operationNumToMaxCoinNum.get(operationNum) + c[i]));
        }
      }

      operationNumToMaxCoinNum = nextOperationNumToMaxCoinNum;
    }

    return operationNumToMaxCoinNum.values().stream().mapToInt(x -> x).max().getAsInt();
  }
}
