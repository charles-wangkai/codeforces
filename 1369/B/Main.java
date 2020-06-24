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

    static String solve(String s) {
        int beginIndex = -1;
        while (beginIndex + 1 != s.length() && s.charAt(beginIndex + 1) == '0') {
            ++beginIndex;
        }

        int endIndex = s.length();
        while (endIndex != 0 && s.charAt(endIndex - 1) == '1') {
            --endIndex;
        }

        return String.format("%s%s%s", s.substring(0, beginIndex + 1), (beginIndex + 1 == endIndex) ? "" : "0",
                s.substring(endIndex));
    }
}