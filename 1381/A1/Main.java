import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            sc.nextInt();
            String a = sc.next();
            String b = sc.next();

            System.out.println(solve(a, b));
        }

        sc.close();
    }

    static String solve(String a, String b) {
        List<Integer> operations = new ArrayList<>();
        char[] bits = a.toCharArray();
        for (int i = bits.length - 1; i >= 0; --i) {
            if (bits[i] != b.charAt(i)) {
                if (i != 0 && bits[0] == b.charAt(i)) {
                    operations.add(1);
                    operate(bits, 1);
                }

                operations.add(i + 1);
                operate(bits, i + 1);
            }
        }

        return String.format("%d %s", operations.size(),
                operations.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    static void operate(char[] bits, int prefixLength) {
        for (int i = 0; i < prefixLength; ++i) {
            bits[i] = (char) ('0' + '1' - bits[i]);
        }

        for (int i = 0, j = prefixLength - 1; i < j; ++i, --j) {
            char temp = bits[i];
            bits[i] = bits[j];
            bits[j] = temp;
        }
    }
}