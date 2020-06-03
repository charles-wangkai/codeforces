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
        int[] lefts = new int[2];
        int[] rights = new int[] { s.replaceAll("1", "").length(), s.replaceAll("0", "").length() };
        int result = Math.min(rights[0], rights[1]);
        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            ++lefts[digit];
            --rights[digit];

            result = Math.min(result, Math.min(lefts[0], lefts[1]) + Math.min(rights[0], rights[1]));
        }

        return result;
    }
}