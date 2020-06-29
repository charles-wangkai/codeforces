import java.util.Scanner;

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

    static int solve(String s) {
        int result = 0;
        int depth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ++depth;
            } else {
                if (depth == 0) {
                    ++result;
                } else {
                    --depth;
                }
            }
        }

        return result;
    }
}