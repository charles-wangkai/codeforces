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

    static int solve(String s) {
        int result = 0;
        int prevIndex = -1;
        for (int i = 0; i <= s.length(); ++i) {
            if (i == s.length() || s.charAt(i) == 'R') {
                result = Math.max(result, i - prevIndex);
                prevIndex = i;
            }
        }

        return result;
    }
}