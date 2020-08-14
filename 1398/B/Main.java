import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            String s = sc.next();

            System.out.println(solve(s));
        }

        sc.close();
    }

    static int solve(String s) {
        List<Integer> oneCounts = new ArrayList<>();
        int oneCount = 0;
        for (int i = 0; i <= s.length(); ++i) {
            if (i != s.length() && s.charAt(i) == '1') {
                ++oneCount;
            } else {
                if (oneCount != 0) {
                    oneCounts.add(oneCount);
                }

                oneCount = 0;
            }
        }

        Collections.sort(oneCounts, Collections.reverseOrder());

        return IntStream.range(0, oneCounts.size()).filter(i -> i % 2 == 0).map(oneCounts::get).sum();
    }
}