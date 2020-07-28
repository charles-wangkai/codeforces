import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    static String solve(String s) {
        int rCount = 0;
        int sCount = 0;
        int pCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'R') {
                ++rCount;
            } else if (ch == 'S') {
                ++sCount;
            } else {
                ++pCount;
            }
        }

        char c;
        if (rCount >= Math.max(sCount, pCount)) {
            c = 'P';
        } else if (sCount >= Math.max(rCount, pCount)) {
            c = 'R';
        } else {
            c = 'S';
        }

        return IntStream.range(0, s.length()).mapToObj(i -> String.valueOf(c)).collect(Collectors.joining());
    }
}