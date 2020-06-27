import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            String s = sc.next();

            System.out.println(solve(s));
        }

        sc.close();
    }

    static long solve(String s) {
        long result = s.length();
        int sum = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '+') {
                ++sum;
            } else {
                --sum;
                if (sum == -1) {
                    result += i + 1;
                    sum = 0;
                }
            }
        }

        return result;
    }
}