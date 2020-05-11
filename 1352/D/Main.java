import java.util.Scanner;

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

            System.out.println(solve(a));
        }

        sc.close();
    }

    static String solve(int[] a) {
        int leftIndex = 0;
        int rightIndex = a.length - 1;
        boolean leftOrRight = true;
        int moveCount = 0;
        int prev = 0;
        int leftSum = 0;
        int rightSum = 0;

        while (leftIndex <= rightIndex) {
            ++moveCount;

            int sum = 0;
            while (leftIndex <= rightIndex && sum <= prev) {
                if (leftOrRight) {
                    sum += a[leftIndex];
                    leftSum += a[leftIndex];
                    ++leftIndex;
                } else {
                    sum += a[rightIndex];
                    rightSum += a[rightIndex];
                    --rightIndex;
                }
            }

            leftOrRight = !leftOrRight;
            prev = sum;
        }

        return String.format("%d %d %d", moveCount, leftSum, rightSum);
    }
}