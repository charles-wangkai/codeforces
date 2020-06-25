import java.util.Scanner;

public class Main {
    static final String TARGET = "codeforces";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long k = sc.nextLong();

        System.out.println(solve(k));

        sc.close();
    }

    static String solve(long k) {
        for (int length = TARGET.length();; ++length) {
            long wayNum = 1;
            for (int i = 0; i < TARGET.length(); ++i) {
                wayNum *= length / TARGET.length() + ((i < length % TARGET.length()) ? 1 : 0);
            }

            if (wayNum >= k) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < TARGET.length(); ++i) {
                    for (int j = 0; j < length / TARGET.length() + ((i < length % TARGET.length()) ? 1 : 0); ++j) {
                        result.append(TARGET.charAt(i));
                    }
                }

                return result.toString();
            }
        }
    }
}