import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            System.out.println(solve(s, k));
        }

        sc.close();
    }

    static int solve(String s, int k) {
        int n = s.length();

        int leftDistance = k;
        int[] leftDistances = new int[n];
        for (int i = 0; i < leftDistances.length; ++i) {
            ++leftDistance;
            if (s.charAt(i) == '1') {
                leftDistance = 0;
            }

            leftDistances[i] = leftDistance;
        }

        int rightDistance = k;
        int[] rightDistances = new int[n];
        for (int i = rightDistances.length - 1; i >= 0; --i) {
            ++rightDistance;
            if (s.charAt(i) == '1') {
                rightDistance = 0;
            }

            rightDistances[i] = rightDistance;
        }

        int result = 0;
        int index = 0;
        while (index < n) {
            if (s.charAt(index) == '0' && leftDistances[index] > k && rightDistances[index] > k) {
                ++result;
                index += k + 1;
            } else {
                ++index;
            }
        }

        return result;
    }
}